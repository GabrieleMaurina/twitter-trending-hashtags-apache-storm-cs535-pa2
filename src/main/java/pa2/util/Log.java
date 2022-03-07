package pa2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Log {
	private static final String HASHTAGS_LOG_FILE = "hashtags_log.txt";
	
	public static void logTopHashtags(List<String> hashtags) {
		hashtags.add(0, String.valueOf(System.currentTimeMillis()));
		try {
			Files.write(Paths.get(HASHTAGS_LOG_FILE),
					(String.join(" ", hashtags) + '\n').getBytes(),
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
