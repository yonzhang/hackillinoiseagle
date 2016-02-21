package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

public class MetadataMemoryDAOImpl implements MetadataDAO{
	private ArrayList<Metric> metrics = new ArrayList<Metric>();
	private ArrayList<Group> groups = new ArrayList<Group>();
	
	public ArrayList<Group> findAllGroups(){
		return groups;
	}
	
	public ArrayList<Metric> findAllMetrics(){
		System.out.println(metrics.size());
		return metrics;
	}
	
	public boolean addMetric(int id){
		Metric m = new Metric(id);
		if(metrics.add(m)){
			System.out.println("Size: " + metrics.size());
			return true;
		}
		else
			return false;
	}
	public boolean addGroup(int id, ArrayList<Metric> metrics){
		Group g = new Group(id, metrics);
		if(groups.add(g))
			return true;
		else
			return false;
	}
}
