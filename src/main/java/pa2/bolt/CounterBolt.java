package pa2.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import pa2.counter.ICounter;

public abstract class CounterBolt implements IRichBolt {

	private static final long serialVersionUID = 5421803323160213121L;

	protected final long delay;

	protected ICounter counter;
	protected OutputCollector collector;

	private long last = 0;

	public CounterBolt(long delay) {
		this.delay = delay;
	}

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		counter.push(input.getString(0));
		emit();
	}

	private void emit() {
		long time = System.currentTimeMillis();
		if (last == 0) {
			last = time;
		} else if (time - last >= delay) {
			last = time;
			collector.emit(new Values(counter.getTop()));
			counter.reset();
		}
	}

	@Override
	public void cleanup() {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("counts"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
