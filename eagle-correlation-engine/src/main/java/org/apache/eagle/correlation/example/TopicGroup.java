package org.apache.eagle.correlation.example;

import java.util.ArrayList;

public class TopicGroup {
	private String grp_name;
	private ArrayList<String> topic_names;

	public TopicGroup(String grpname, ArrayList<String> topics) {
		grp_name = grpname;
		topic_names = topics;

	}

	public String getName() {
		return grp_name;
	}
}
