package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

public interface MetadataDAO<T> {
	ArrayList<T> findAllMetrics();
	ArrayList<Group> findAllGroups();
	boolean addMetric(T id);
	boolean addGroup(T id, ArrayList<T> metrics);
}
