package pa2.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;

import pa2.counter.LossyCounter;

public class LossyBolt extends CounterBolt {

	private static final long serialVersionUID = 6484523633235299460L;

	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		super.prepare(topoConf, context, collector);
		counter = new LossyCounter();
	}
}
