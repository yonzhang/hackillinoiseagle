package org.apache.eagle.correlation.example;

import java.util.ArrayList;

public class TopicGroup {
	private String grp_name;
	private ArrayList<String> topic_names;
	private String message;

	public TopicGroup(String grpname, ArrayList<String> topics, String msg) {
		grp_name = grpname;
		topic_names = topics;
		message = msg;
	}
}
