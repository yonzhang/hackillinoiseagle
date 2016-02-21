package org.apache.eagle.service.correlation.api;

public class Metric {
	private static int metricID;
	
	public Metric(int ID){
		this.metricID = ID;
	}
	
	public int getId(){
		return this.metricID;
	}
}
