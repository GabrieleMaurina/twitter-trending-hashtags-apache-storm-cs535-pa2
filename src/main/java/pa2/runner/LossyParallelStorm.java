package pa2.runner;

import pa2.bolt.CounterBolt;
import pa2.bolt.LossyCounterBolt;

public class LossyParallelStorm extends ParallelStorm {

	public static void main(String[] args) {
		new LossyParallelStorm().run();
	}

	@Override
	protected CounterBolt getCounterBolt() {
		return new LossyCounterBolt(DELAY);
	}
}
