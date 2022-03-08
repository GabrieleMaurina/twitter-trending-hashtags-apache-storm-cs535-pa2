package pa2.bolt;

import java.util.List;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.javatuples.Pair;

import pa2.counter.LossyCounter;

public class AggregatorBolt implements IRichBolt {

	private static final long serialVersionUID = 8184954853219589808L;

	private int counters;
	private int count;
	private List<Pair<String, Integer>> counts;

	private OutputCollector collector;

	public AggregatorBolt(int counters) {
		this.counters = counters;
	}

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		count = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized void execute(Tuple input) {
		List<Pair<String, Integer>> values = (List<Pair<String, Integer>>) input.getValue(0);
		if(counts == null) {
			counts = values;
			count = 1;
		}
		else {
			counts.addAll(values);
			count++;
		}
		if(count >= counters) {
			collector.emit(new Values(counts.stream().sorted((v1, v2) -> v2.getValue0().compareTo(v1.getValue0())).limit(LossyCounter.W).toList()));
			count = 0;
			counts = null;
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
