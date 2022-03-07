package pa2.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public abstract class Runner {
	protected static final long DELAY = 10000;

	public abstract void run();
}
