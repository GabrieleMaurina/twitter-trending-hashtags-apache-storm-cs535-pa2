package pa2.counter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

public class LosslessCounter implements ICounter {

	private Map<String, Integer> count;

	@Override
	public void push(String s) {
		count.put(s, count.getOrDefault(s, 0) + 1);
	}

	@Override
	public List<Triplet<String, Integer, Integer>> getTop() {
		return count.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).limit(SIZE)
				.map(e -> new Triplet<String, Integer, Integer>(e.getKey(), e.getValue(), 0))
				.collect(Collectors.toList());
	}

	@Override
	public void reset() {
		count.clear();
	}
}
