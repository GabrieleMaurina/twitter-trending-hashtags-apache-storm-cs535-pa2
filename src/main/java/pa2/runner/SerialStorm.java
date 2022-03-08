package pa2.runner;

import pa2.bolt.CounterBolt;
import pa2.bolt.LoggerBolt;
import pa2.spout.HashtagsSpout;

public abstract class SerialStorm extends Storm {

	protected SerialStorm() {
		topologyBuilder.setSpout("hashtags", new HashtagsSpout(), 1);
		topologyBuilder.setBolt("counter", getCounterBolt(), 1).globalGrouping("hashtags");
		topologyBuilder.setBolt("logger", new LoggerBolt(), 1).globalGrouping("counter");
	}
	
	protected abstract CounterBolt getCounterBolt();
}
