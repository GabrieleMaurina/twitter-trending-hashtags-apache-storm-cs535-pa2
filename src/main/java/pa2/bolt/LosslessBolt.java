package pa2.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

import pa2.counter.ICounter;
import pa2.counter.LosslessCounter;
import pa2.twitter.Twitter;

public class LosslessBolt implements IRichBolt {

	private static final long serialVersionUID = 981042445038703906L;
	private ICounter counter;

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		counter = new LosslessCounter();
	}

	@Override
	public void execute(Tuple input) {
		System.out.println(input);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
