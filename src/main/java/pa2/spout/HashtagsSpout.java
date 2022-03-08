package pa2.spout;

import java.util.Collections;
import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;

import pa2.twitter.Twitter;

public class HashtagsSpout implements IRichSpout {

	private static final long serialVersionUID = 7550907673077716974L;

	private SpoutOutputCollector collector;
	private Twitter twitter;

	@Override
	public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
		twitter = new Twitter(this::onHashtag);
		twitter.start();
	}

	private void onHashtag(String hashtag) {
		collector.emit(Collections.singletonList(hashtag));
	}

	@Override
	public void close() {
		twitter = null;
	}

	@Override
	public void activate() {
	}

	@Override
	public void deactivate() {
	}

	@Override
	public void nextTuple() {
	}

	@Override
	public void ack(Object msgId) {
	}

	@Override
	public void fail(Object msgId) {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("hashtags"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
