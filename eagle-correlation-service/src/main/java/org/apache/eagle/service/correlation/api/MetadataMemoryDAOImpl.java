package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

public class MetadataMemoryDAOImpl implements MetadataDAO {
	public ArrayList<Group> findAllGroups() {
		return MetadataMemoryManager.getInstance().findAllGroups();
	}

	public ArrayList<Metric> findAllMetrics() {
		return MetadataMemoryManager.getInstance().findAllMetrics();
	}

	public boolean addMetric(int id) {
		return MetadataMemoryManager.getInstance().addMetric(id);
	}

	public boolean addGroup(int id, ArrayList<Metric> metrics) {
		return MetadataMemoryManager.getInstance().addGroup(id, metrics);
	}
}