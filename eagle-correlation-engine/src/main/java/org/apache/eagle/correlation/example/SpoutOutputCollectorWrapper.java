package org.apache.eagle.correlation.example;

import java.util.List;
import java.util.Map;

import org.apache.eagle.correlation.client.IMetadataClient;
import org.apache.eagle.correlation.client.MetadataClientImpl;

import backtype.storm.spout.ISpoutOutputCollector;
import backtype.storm.spout.SpoutOutputCollector;

/**
 * Created by yonzhang on 2/18/16. wrap SpoutOutputCollector so Eagle can
 * intercept the message sent from within KafkaSpout collector.emit(tup, new
 * KafkaMessageId(_partition, toEmit.offset));
 */
public class SpoutOutputCollectorWrapper extends SpoutOutputCollector {
	private ISpoutOutputCollector delegate;
	private int numBolts;

	public SpoutOutputCollectorWrapper(ISpoutOutputCollector delegate,
			int numBolts) {
		super(delegate);
		this.delegate = delegate;
		this.numBolts = numBolts;
	}

	@Override
	public List<Integer> emit(List<Object> tuple, Object messageId) {
		// decode tuple to have field topic and field f1
		String topic = (String) tuple.get(0);
		System.out.println("emitted tuple: " + tuple + ", with message Id: "
				+ messageId + ", with topic " + topic);
		KafkaMessageIdWrapper newMessageId = new KafkaMessageIdWrapper(
				messageId);
		newMessageId.topic = topic;
		/*
		 * if(topic.equals("topic1")){ delegate.emit("stream1", tuple,
		 * newMessageId); delegate.emit("stream3", tuple, newMessageId); }
		 */
		String basePath = "http://localhost:38080";
		IMetadataClient client = new MetadataClientImpl(basePath);
		Map<String, List<String>> groups = client.findAllGroups();
		for (Map.Entry<String, List<String>> e : groups.entrySet()) {
			if (e.getValue().contains(topic)) {
				delegate.emit("stream_" + e.getKey().hashCode() % numBolts,
						tuple, newMessageId);
			}
		}
		return null;
	}
}
