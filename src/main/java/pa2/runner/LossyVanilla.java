package pa2.runner;

import pa2.counter.LossyCounter;
import pa2.twitter.Twitter;

public class LossyVanilla extends Vanilla {

	public LossyVanilla() {
		counter = new LossyCounter();
		twitter = new Twitter(counter::push);
	}

	public static void main(String[] args) {
		new LossyVanilla().run();
	}
}
