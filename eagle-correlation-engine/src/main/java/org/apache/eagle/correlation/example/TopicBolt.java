package org.apache.eagle.correlation.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

/**
 * Created by yonzhang on 2/18/16.
 */
public class TopicBolt implements IRichBolt {
	private OutputCollector collector;
	private HashMap<String, TopicGroup> topic_groups;
	private HashMap<String, ArrayList<String>> metadata;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		// create a new thread to download meta-data from service thread runs
		// every minute
	}

	@Override
	public void execute(Tuple input) {
		collector.ack(input);
		System.out.println("tuple is coming: " + input);
		// get the topic and group of the input message
		List<Object> field_values = input.getValues();
		String topic_name = (String) field_values.get(0);
		// String message = (String) field_values.get(1);
		ArrayList<String> message_topic_groups = new ArrayList<String>();
		// map each topic name with
		// get the list of groups from metadata
		Iterator it = metadata.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String key = (String) pair.getKey();
			ArrayList<String> topics = (ArrayList<String>) pair.getValue();
			// key=grpname and value=list of topics
			if (topics.contains(topic_name)) {
				message_topic_groups.add(key); // add current group to list of
												// groups
			}
		}
		
	}

	@Override
	public void cleanup() {

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}
}
