package pa2.runner;

import pa2.bolt.LosslessBolt;

public class LosslessSimpleStorm extends SimpleStorm{
	
	public LosslessSimpleStorm() {
		topologyBuilder.setBolt("lossless", new LosslessBolt(), 1).allGrouping("hashtags");
	}
	
	public static void main(String[] args) {
		new LosslessSimpleStorm().run();
	}
}
