package pa2.runner;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;

import pa2.bolt.LosslessBolt;
import pa2.spout.HashtagsSpout;

public class LosslessSimpleStorm extends Runner{

	@Override
	public void run() {
		TopologyBuilder topologyBuilder = new TopologyBuilder();        
		topologyBuilder.setSpout("hashtags", new HashtagsSpout(), 1);        
		topologyBuilder.setBolt("lossless", new LosslessBolt(), 1).allGrouping("hashtags");
		Config conf = new Config();
		try {
			StormSubmitter.submitTopology("losslessSimpleStorm", conf, topologyBuilder.createTopology());
		} catch (AlreadyAliveException | InvalidTopologyException | AuthorizationException e) {
			e.printStackTrace();
		}
	}
}
