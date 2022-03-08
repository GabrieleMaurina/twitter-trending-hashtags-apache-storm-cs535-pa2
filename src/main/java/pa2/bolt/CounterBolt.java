package pa2.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import pa2.counter.ICounter;

public abstract class CounterBolt implements IRichBolt {

	private static final long serialVersionUID = 5421803323160213121L;

	protected ICounter counter;
	protected TopologyContext context;
	protected OutputCollector collector;

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		this.context = context;
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		System.out.println(input);
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
