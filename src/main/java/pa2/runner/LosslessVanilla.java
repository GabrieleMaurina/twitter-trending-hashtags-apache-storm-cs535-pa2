package pa2.runner;

import pa2.counter.LosslessCounter;

public class LosslessVanilla extends Vanilla {

	public LosslessVanilla() {
		super();
		counter = new LosslessCounter();
	}
}
