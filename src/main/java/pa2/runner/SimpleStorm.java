package pa2.runner;

import pa2.spout.HashtagsSpout;

public abstract class SimpleStorm extends Storm {

	protected SimpleStorm() {
		topologyBuilder.setSpout("hashtags", new HashtagsSpout(), 1);
	}
}
