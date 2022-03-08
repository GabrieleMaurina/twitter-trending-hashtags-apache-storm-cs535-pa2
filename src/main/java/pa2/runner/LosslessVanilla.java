package pa2.runner;

import pa2.counter.LosslessCounter;
import pa2.twitter.Twitter;

public class LosslessVanilla extends Vanilla {

	public LosslessVanilla() {
		counter = new LosslessCounter();
		twitter = new Twitter(counter::push);
	}

	public static void main(String[] args) {
		new LosslessVanilla().run();
	}
}
