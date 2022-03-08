package pa2.runner;

import pa2.bolt.LossyBolt;

public class LossySimpleStorm extends SimpleStorm {

	public LossySimpleStorm() {
		topologyBuilder.setBolt("lossy", new LossyBolt(), 1).allGrouping("hashtags");
	}

	public static void main(String[] args) {
		new LosslessSimpleStorm().run();
	}
}
