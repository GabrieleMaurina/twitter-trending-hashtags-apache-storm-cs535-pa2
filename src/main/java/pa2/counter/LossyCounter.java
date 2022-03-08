package pa2.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.javatuples.Pair;

public class LossyCounter implements ICounter {

	public static final int W = 100;

	private int n;
	private Map<String, Pair<Integer, Integer>> d;

	public LossyCounter() {
		d = new HashMap<String, Pair<Integer, Integer>>();
		reset();
	}

	public int getW() {
		return W;
	}

	public int getB() {
		return (int) Math.ceil((double) n / W);
	}

	public int getN() {
		return n;
	}

	@Override
	public void push(String s) {
		n++;
		Pair<Integer, Integer> v = d.getOrDefault(s, new Pair<Integer, Integer>(0, getB() - 1));
		d.put(s, new Pair<Integer, Integer>(v.getValue0() + 1, v.getValue1()));
		purge();
	}

	private void purge() {
		if (n % W == 0) {
			d.values().removeIf(v -> v.getValue0() + v.getValue1() <= getB());
		}
	}

	@Override
	public List<Pair<String, Integer>> getTop() {
		return d.entrySet().stream().sorted((e1, e2) -> e2.getValue().getValue0().compareTo(e1.getValue().getValue0()))
				.limit(SIZE).map(e -> new Pair<String, Integer>(e.getKey(), e.getValue().getValue0()))
				.collect(Collectors.toList());
	}

	@Override
	public void reset() {
		d.clear();
		n = 0;
	}
}
