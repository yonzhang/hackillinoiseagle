package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

/**
 * Created by yonzhang on 2/20/16.
 */
public class MetadataMemoryManager<T> {
    private static MetadataMemoryManager instance = new MetadataMemoryManager();
    private ArrayList<T> metrics = new ArrayList<T>();
    private ArrayList<Group> groups = new ArrayList<Group>();

    private MetadataMemoryManager() {

    }

    public static MetadataMemoryManager getInstance() {
        return instance;
    }

    public ArrayList<Group> findAllGroups() {
        return groups;
    }

    public ArrayList<T> findAllMetrics() {
        return metrics;
    }

    public boolean addMetric(T id){
        T m = id;
        if(metrics.add(m)){
            return true;
        }
        else
            return false;
    }
    public boolean addGroup(T id, ArrayList<T> metrics){
        Group g = new Group(id, metrics);
        if(groups.add(g))
            return true;
        else
            return false;
    }
    
    public boolean checkMetric(T id){
    	return metrics.contains(id);
    		
    }
    
    public boolean checkGroup(T id){
    	for(int i = 0; i < groups.size(); i++){
    		if(groups.get(i).getId().equals(id))
    			return true;
    	}
    	return false;
    }
}
