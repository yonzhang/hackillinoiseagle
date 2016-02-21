package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

public class MetadataMemoryDAOImpl<T> implements MetadataDAO<T> {
	public ArrayList<Group> findAllGroups() {
		return MetadataMemoryManager.getInstance().findAllGroups();
	}

	public ArrayList<T> findAllMetrics() {
		return MetadataMemoryManager.getInstance().findAllMetrics();
	}

	public boolean addMetric(T id) {
		return MetadataMemoryManager.getInstance().addMetric(id);
	}

	public boolean addGroup(T id, ArrayList<T> metrics) {
		return MetadataMemoryManager.getInstance().addGroup(id, metrics);
	}
}