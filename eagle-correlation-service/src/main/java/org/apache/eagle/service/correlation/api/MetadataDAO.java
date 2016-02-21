package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;
import java.util.HashMap;

public interface MetadataDAO<T> {
	ArrayList<T> findAllMetrics();
	 HashMap<T, ArrayList<T> > findAllGroups();
	boolean addMetric(T id);
	boolean addGroup(T id, ArrayList<T> metrics);
}
