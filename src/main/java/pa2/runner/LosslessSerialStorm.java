package pa2.runner;

import pa2.bolt.CounterBolt;
import pa2.bolt.LosslessCounterBolt;

public class LosslessSerialStorm extends SerialStorm {

	public static void main(String[] args) {
		new LosslessSerialStorm().run();
	}

	@Override
	protected CounterBolt getCounterBolt() {
		return new LosslessCounterBolt(DELAY);
	}
}
