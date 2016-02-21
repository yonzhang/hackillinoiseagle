package org.apache.eagle.service.correlation.api;
import java.util.ArrayList;

public class Group<T> {
	private T groupID;
	public ArrayList<T> metrics = new ArrayList<T>();
	
	public Group(T ID){
		this.groupID = ID;
	}
	
	public Group(T ID, ArrayList<T> metric){
		this.groupID = ID;
		this.metrics = metric;
	}
	
	public T getId(){
		return this.groupID;
	}
	
	public ArrayList<T> getMetrics(){
		return this.metrics;
	}
	
	public void addMetric(T  metric){
		metrics.add(metric);
	}
}