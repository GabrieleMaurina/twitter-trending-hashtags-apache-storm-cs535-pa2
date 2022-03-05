package pa2.runner;

import pa2.counter.LossyCounter;

public class LossyVanilla extends Vanilla {

	public LossyVanilla() {
		super();
		counter = new LossyCounter(W);
	}
}
