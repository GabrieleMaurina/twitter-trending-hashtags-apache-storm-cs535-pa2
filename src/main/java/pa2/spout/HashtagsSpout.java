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
	private boolean active;

	@Override
	public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
		active = false;
		this.collector = collector;
		twitter = new Twitter(this::onHashtag);
		twitter.start();
	}

	private void onHashtag(String hashtag) {
		if (active) {
			collector.emit(Collections.singletonList(hashtag));
		}
	}

	@Override
	public void close() {
		twitter = null;
		deactivate();
	}

	@Override
	public void activate() {
		active = true;
	}

	@Override
	public void deactivate() {
		active = false;
	}

	@Override
	public void nextTuple() {
		activate();
	}

	@Override
	public void ack(Object msgId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fail(Object msgId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("hashtag"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
