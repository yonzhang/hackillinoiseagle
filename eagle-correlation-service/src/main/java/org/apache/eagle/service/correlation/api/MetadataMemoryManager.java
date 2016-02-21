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
            System.out.println("Size: " + metrics.size());
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
}
