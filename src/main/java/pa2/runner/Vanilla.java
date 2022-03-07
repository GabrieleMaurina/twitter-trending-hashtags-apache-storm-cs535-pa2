package pa2.runner;

import pa2.counter.ICounter;
import pa2.twitter.Twitter;
import pa2.util.Log;
import pa2.util.Time;

public abstract class Vanilla extends Runner {

	protected ICounter counter;
	protected Twitter twitter;

	@Override
	public void run() {
		twitter.start();
		while (true) {
			Time.sleep(DELAY);
			Log.logTopHashtags(counter.getTop());
			counter.reset();
		}
	}
}
