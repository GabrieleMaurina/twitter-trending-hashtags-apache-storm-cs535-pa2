package pa2.runner;

import java.util.List;

import org.javatuples.Triplet;

public abstract class Runner {

	protected static final long DELAY = 10000;
	protected static final int W = 10000;
	
	public abstract void run();
	
	protected void printTop(List<Triplet<String, Integer, Integer>> hashtags) {
		for(Triplet<String, Integer, Integer> v: hashtags) {
			System.out.println(v);
		}
		System.out.println();
	}
}
