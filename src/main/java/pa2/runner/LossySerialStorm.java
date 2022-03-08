package pa2.runner;

import pa2.bolt.CounterBolt;
import pa2.bolt.LossyCounterBolt;

public class LossySerialStorm extends SerialStorm {

	public static void main(String[] args) {
		new LossySerialStorm().run();
	}

	@Override
	protected CounterBolt getCounterBolt() {
		return new LossyCounterBolt(DELAY);
	}
}
