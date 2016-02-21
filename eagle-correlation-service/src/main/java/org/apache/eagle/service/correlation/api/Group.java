package org.apache.eagle.service.correlation.api;
import java.util.ArrayList;

public class Group {
	private static int groupID;
	public static ArrayList<Metric> events = new ArrayList<Metric>();
	
	public Group(int ID){
		this.groupID = ID;
	}
	
	public Group(int ID, ArrayList<Metric> events){
		this.groupID = ID;
		this.events = events;
	}
	
	public int getId(){
		return this.groupID;
	}
	
	public ArrayList<Metric> getEvents(){
		return this.events;
	}
	
	public void addMetric(Metric event){
		events.add(event);
	}
}