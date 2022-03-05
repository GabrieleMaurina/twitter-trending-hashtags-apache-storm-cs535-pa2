package pa2.runner;

import pa2.counter.ICounter;
import pa2.twitter.T4J;
import pa2.util.Time;

public abstract class Vanilla extends Runner {

	protected ICounter counter;
	protected T4J t4j;

	@Override
	public void run() {
		while (true) {
			t4j.start();
			Time.sleep(DELAY);
			t4j.stop();
			logTopHashtags(counter.getTop());
			counter.reset();
		}
	}
}
