package pa2.runner;

import pa2.counter.LossyCounter;
import pa2.twitter.T4J;

public class LossyVanilla extends Vanilla {

	public LossyVanilla() {
		counter = new LossyCounter(W);
		t4j = new T4J(counter::push);
	}
}
