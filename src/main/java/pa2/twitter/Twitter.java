package pa2.twitter;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.tweet.Tweet;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import pa2.util.FilePaths;

public class Twitter {
	
	private static final Pattern hashtagPattern = Pattern.compile("#([\\w\\d_]+)");

	private TwitterClient twitterClient;
	private Consumer<Tweet> hashtagCallback;

	public Twitter(Consumer<String> hashtagCallback) {
		this.hashtagCallback = tweet -> {
			Matcher matcher = hashtagPattern.matcher(tweet.getText());
			while(matcher.find()) {
				hashtagCallback.accept(matcher.group(1).toLowerCase());
			}
		};

		try {
			twitterClient = new TwitterClient(
					TwitterClient.OBJECT_MAPPER.readValue(new File(FilePaths.TWITTERED_JSON), TwitterCredentials.class));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void start() {
		twitterClient.startSampledStream(hashtagCallback);
	}
}
