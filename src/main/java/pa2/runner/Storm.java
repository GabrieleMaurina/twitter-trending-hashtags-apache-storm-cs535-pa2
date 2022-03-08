package pa2.runner;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;

public abstract class Storm extends Runner {

	TopologyBuilder topologyBuilder;
	Config conf;
	String topologyName;

	protected Storm() {
		topologyBuilder = new TopologyBuilder();
		conf = new Config();
	}

	@Override
	public void run() {
		try {
			StormSubmitter.submitTopology(getClass().getSimpleName(), conf, topologyBuilder.createTopology());
		} catch (AlreadyAliveException | InvalidTopologyException | AuthorizationException e) {
			e.printStackTrace();
		}
	}
}
