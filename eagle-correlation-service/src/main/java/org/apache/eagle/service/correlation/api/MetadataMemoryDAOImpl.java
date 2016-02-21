package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;
import java.util.HashMap;

public class MetadataMemoryDAOImpl<T> implements MetadataDAO<T> {
	public  HashMap<T, ArrayList<T> > findAllGroups() {
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
	
	public boolean checkMetric(T id) {
		return MetadataMemoryManager.getInstance().checkMetric(id);
	}
	
	public boolean checkGroup(T id) {
		return MetadataMemoryManager.getInstance().checkGroup(id);
	}
}