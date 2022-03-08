package pa2.runner;

import org.apache.storm.tuple.Fields;

import pa2.bolt.AggregatorBolt;
import pa2.bolt.CounterBolt;
import pa2.bolt.LoggerBolt;
import pa2.spout.HashtagsSpout;

public abstract class ParallelStorm extends Storm {
	
	private static final int COUNTERS = 4;

	protected ParallelStorm() {
		topologyBuilder.setSpout("hashtags", new HashtagsSpout(), 1);
		topologyBuilder.setBolt("counter", getCounterBolt(), COUNTERS).fieldsGrouping("hashtags", new Fields("hashtags"));
		topologyBuilder.setBolt("aggregator", new AggregatorBolt(COUNTERS), 1).globalGrouping("counter");
		topologyBuilder.setBolt("logger", new LoggerBolt(), 1).globalGrouping("aggregator");
	}

	protected abstract CounterBolt getCounterBolt();
}
