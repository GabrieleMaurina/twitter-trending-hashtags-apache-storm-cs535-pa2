package pa2.runner;

import pa2.counter.ICounter;
import pa2.twitter.T4J;
import pa2.util.Time;

public abstract class Vanilla extends Runner {

	protected ICounter counter;
	private T4J t4j;

	public Vanilla() {
		t4j = new T4J(counter::push);
	}

	@Override
	public void run() {
		while (true) {
			t4j.start();
			Time.sleep(DELAY);
			t4j.stop();
			printTop(counter.getTop());
			counter.reset();
		}
	}
}
