package pa2.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.javatuples.Pair;

public class Log {
	private static final String HASHTAGS_LOG_FILE = "hashtags_log.txt";

	public static void logTopHashtags(List<Pair<String, Integer>> hashtags) {
		hashtags.add(0, new Pair<String, Integer>(String.valueOf(System.currentTimeMillis()), 0));
		File hashtagsFile = new File(HASHTAGS_LOG_FILE);
		try {
			if (!hashtagsFile.exists()) {
				Files.write(Paths.get(HASHTAGS_LOG_FILE), ("Log file\n").getBytes(), StandardOpenOption.CREATE);
			}
			Files.write(Paths.get(HASHTAGS_LOG_FILE),
					("<" + String.join("><", hashtags.stream().map(v -> v.getValue0()).toList()) + ">\n").getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
