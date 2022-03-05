package pa2.counter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.javatuples.Triplet;

public class LossyCounter implements ICounter {

	private int w;
	private int n;
	private Map<String, Pair<Integer, Integer>> d;

	public LossyCounter(int w) {
		this.w = w;
		reset();
	}

	public int getW() {
		return w;
	}

	public int getB() {
		return (int) Math.ceil((double) n / w);
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
		if (n % w == 0) {
			d.values().removeIf(v -> v.getValue0() + v.getValue1() <= getB());
		}
	}

	@Override
	public List<Triplet<String, Integer, Integer>> getTop() {
		return d.entrySet().stream().sorted((e1, e2) -> e1.getValue().getValue0().compareTo(e2.getValue().getValue0()))
				.limit(SIZE).map(e -> new Triplet<String, Integer, Integer>(e.getKey(), e.getValue().getValue0(),
						e.getValue().getValue1()))
				.collect(Collectors.toList());
	}

	@Override
	public void reset() {
		d.clear();
		n = 0;
	}
}
