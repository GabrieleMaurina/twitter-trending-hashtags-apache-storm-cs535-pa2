package pa2.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LosslessCounter implements ICounter {

	private Map<String, Integer> count;
	
	public LosslessCounter() {
		count = new HashMap<String, Integer>();
	}

	@Override
	public void push(String s) {
		count.put(s, count.getOrDefault(s, 0) + 1);
	}

	@Override
	public List<String> getTop() {
		return count.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(SIZE)
				.map(e -> e.getKey()).collect(Collectors.toList());
	}

	@Override
	public void reset() {
		count.clear();
	}
}
