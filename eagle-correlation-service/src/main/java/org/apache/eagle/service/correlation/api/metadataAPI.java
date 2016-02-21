package org.apache.eagle.service.correlation.api;

import org.apache.eagle.service.correlation.api.TestAPI.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;



@Path("/")
public class metadataAPI<T> {
	MetadataMemoryDAOImpl mdObj = new MetadataMemoryDAOImpl();
	
    @GET
    @Path("/topics")
    @Produces({"application/json"})
    public Response findMetrics(){
    	Response r = new Response();
    	r.metrics = new ArrayList<T>();
    	
    	ArrayList<T> m = mdObj.findAllMetrics();
    	for(int i = 0; i < m.size(); i++){
    		r.metrics.add(m.get(i));
    	}
    	
    	return r;
    }
    
    @GET
    @Path("/groups")
    @Produces({"application/json"})
    public Response findGroups(){
    	Response r = new Response();
    	r.groups = new ArrayList<Group>();
    	
    	ArrayList<Group> g = mdObj.findAllGroups();
    	for(int i = 0; i < g.size(); i++){
    		r.groups.add(g.get(i));
    	}
    	
    	return r;
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
    	
    	mdObj.addGroup(groupId, metricArray);
    	
    	return "Success";
    }
    
    @SuppressWarnings({"rawtypes"})
    @POST
    @Path("/addTopic")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String addMetric(String id){ 
    	if(mdObj.addMetric(id))
    		return "Success";
    	else
    		return "Failure";
    }
    
      
    
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {})
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Response <T>{
		public ArrayList<Group> groups;
		public ArrayList<T> metrics;
    }
 
}