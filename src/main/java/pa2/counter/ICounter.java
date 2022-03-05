package pa2.counter;

import java.util.List;

import org.javatuples.Triplet;

public interface ICounter {

	public void push(String s);

	public List<Triplet<String, Integer, Integer>> getSorted();

	public void reset();
}
