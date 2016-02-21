package org.apache.eagle.service.correlation.api;

import org.apache.eagle.service.correlation.api.TestAPI.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.*;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;



@Path("/")
public class metadataAPI<T> {
	MetadataMemoryDAOImpl mdObj = new MetadataMemoryDAOImpl();
	
    @GET
    @Path("/topics")
    @Produces({"application/json"})
    public ArrayList<T> findMetrics(){
    	return mdObj.findAllMetrics();
    }
    
    @GET
    @Path("/groups")
    @Produces({"application/json"})
    public  HashMap<T, ArrayList<T> > findGroups(){
    	 HashMap<T, ArrayList<T> > g = mdObj.findAllGroups();
    	 return g;
    }
    
    @SuppressWarnings({"rawtypes"})
    @POST
    @Path("/addGroup")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String addGroup(String data) {
    	String[] ary = data.split(",");
    	T groupId = (T) ary[0];
    	
    	ArrayList<T> metricArray = new ArrayList<T>();
    	
    	for(int i = 1; i < ary.length; i++){	
    		metricArray.add((T) ary[i]);
    	}
    	
    	if(mdObj.checkGroup(groupId) == true)
    		return "Group ID already exists";
    	
    	if(mdObj.addGroup(groupId, metricArray))
    		return "Success";
    	else
    		return "Failure";
    	
    }
    
    @SuppressWarnings({"rawtypes"})
    @POST
    @Path("/addTopic")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String addMetric(String id){ 
    	if(mdObj.checkMetric(id) == true)
    		return "Metric ID already exists";
    	
    	if(mdObj.addMetric(id))
    		return "Success";
    	else
    		return "Failure";
    }
}