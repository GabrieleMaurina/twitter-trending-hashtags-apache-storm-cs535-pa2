package pa2.counter;

import java.util.List;

import org.javatuples.Triplet;

public interface ICounter {
	
	public final static int SIZE = 100;

	public void push(String s);

	public List<Triplet<String, Integer, Integer>> getTop();

	public void reset();
}
