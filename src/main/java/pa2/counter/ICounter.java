package pa2.counter;

import java.util.List;

import org.javatuples.Pair;

public interface ICounter {
	
	public final static int SIZE = 100;

	public void push(String s);

	public List<Pair<String, Integer>> getTop();

	public void reset();
}
