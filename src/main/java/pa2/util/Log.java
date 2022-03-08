package pa2.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Pair;

public class Log {

	public static void logTopHashtags(List<Pair<String, Integer>> hashtags) {
		hashtags.add(0, new Pair<String, Integer>(String.valueOf(System.currentTimeMillis()), 0));
		File hashtagsFile = new File(FilePaths.HASHTAGS_LOG_FILE);
		try {
			if (!hashtagsFile.exists()) {
				Files.write(Paths.get(FilePaths.HASHTAGS_LOG_FILE), ("Log file\n").getBytes(), StandardOpenOption.CREATE);
			}
			Files.write(Paths.get(FilePaths.HASHTAGS_LOG_FILE),
					("<" + hashtags.stream().map(v -> v.getValue0()).collect(Collectors.joining("><")) + ">\n").getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void log(String s) {
		try {
			Files.write(Paths.get(FilePaths.LOG_FILE), (s + "\n").getBytes(),
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
