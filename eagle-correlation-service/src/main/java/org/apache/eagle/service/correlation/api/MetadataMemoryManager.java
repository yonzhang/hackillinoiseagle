package org.apache.eagle.service.correlation.api;

import java.util.ArrayList;

/**
 * Created by yonzhang on 2/20/16.
 */
public class MetadataMemoryManager {
    private static MetadataMemoryManager instance = new MetadataMemoryManager();
    private ArrayList<Metric> metrics = new ArrayList<Metric>();
    private ArrayList<Group> groups = new ArrayList<Group>();

    private MetadataMemoryManager() {

    }

    public static MetadataMemoryManager getInstance() {
        return instance;
    }

    public ArrayList<Group> findAllGroups() {
        return groups;
    }

    public ArrayList<Metric> findAllMetrics() {
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
