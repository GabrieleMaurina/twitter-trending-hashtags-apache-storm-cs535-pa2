package pa2.runner;

import pa2.counter.LosslessCounter;
import pa2.twitter.T4J;

public class LosslessVanilla extends Vanilla {

	public LosslessVanilla() {
		counter = new LosslessCounter();
		t4j = new T4J(counter::push);
	}
}
