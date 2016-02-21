package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yonzhang on 2/20/16.
 */
public class MetadataMemoryManager<T> {
    private static MetadataMemoryManager instance = new MetadataMemoryManager();
    private ArrayList<T> metrics = new ArrayList<T>();
    private HashMap<T, ArrayList<T> > groups = new HashMap<T, ArrayList<T> >();

    private MetadataMemoryManager() {

    }

    public static MetadataMemoryManager getInstance() {
        return instance;
    }

    public  HashMap<T, ArrayList<T> > findAllGroups() {
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
    public boolean addGroup(T id, ArrayList<T> list){
    	groups.put(id, list);
    	return true;
    }
    
    public boolean checkMetric(T id){
    	return metrics.contains(id);
    		
    }
    
    public boolean checkGroup(T id){
    	return groups.containsKey(id);
    }
}
