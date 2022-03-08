package pa2.bolt;

import java.util.List;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;
import org.javatuples.Pair;

import pa2.util.Log;

public class LoggerBolt implements IRichBolt {

	private static final long serialVersionUID = 4955543359568328420L;

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(Tuple input) {
		Log.logTopHashtags((List<Pair<String, Integer>>) input.getValue(0));
	}

	@Override
	public void cleanup() {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}
}
