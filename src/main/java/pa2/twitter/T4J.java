package pa2.twitter;

import java.util.function.Consumer;

import twitter4j.HashtagEntity;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class T4J {

	private TwitterStream twitterStream;

	public T4J(Consumer<String> hashtagCallback) {
		twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.onStatus(status -> {
			for (HashtagEntity hashtagEntity : status.getHashtagEntities()) {
				hashtagCallback.accept(hashtagEntity.getText().toLowerCase());
			}
		});
	}

	public void start() {
		twitterStream.sample();
	}

	public void stop() {
		twitterStream.cleanUp();
		twitterStream.shutdown();
	}
}
