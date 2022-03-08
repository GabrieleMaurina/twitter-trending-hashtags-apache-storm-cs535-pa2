package pa2.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;

import pa2.counter.LosslessCounter;

public class LosslessCounterBolt extends CounterBolt {

	private static final long serialVersionUID = 981042445038703906L;

	public LosslessCounterBolt(long delay) {
		super(delay);
	}
	
	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		super.prepare(topoConf, context, collector);
		counter = new LosslessCounter();
	}
}
