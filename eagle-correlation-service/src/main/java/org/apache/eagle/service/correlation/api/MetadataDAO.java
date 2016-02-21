package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

public interface MetadataDAO {
	ArrayList<Metric> findAllMetrics();
	ArrayList<Group> findAllGroups();
	boolean addMetric(int id);
	boolean addGroup(int id, ArrayList<Metric> metrics);
}
