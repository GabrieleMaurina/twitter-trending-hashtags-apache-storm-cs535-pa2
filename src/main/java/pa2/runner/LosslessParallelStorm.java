package pa2.runner;

import pa2.bolt.CounterBolt;
import pa2.bolt.LosslessCounterBolt;

public class LosslessParallelStorm extends ParallelStorm{
	
	public static void main(String[] args) {
		new LosslessParallelStorm().run();
	}

	@Override
	protected CounterBolt getCounterBolt() {
		return new LosslessCounterBolt(DELAY);
	}
}
