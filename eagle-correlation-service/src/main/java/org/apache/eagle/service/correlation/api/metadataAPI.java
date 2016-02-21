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
public class metadataAPI {
	MetadataMemoryDAOImpl mdObj = new MetadataMemoryDAOImpl();
	
    @GET
    @Path("/topics")
    @Produces({"application/json"})
    public Response findMetrics(){
    	Response r = new Response();
    	r.metrics = new ArrayList<Metric>();
    	
    	ArrayList<Metric> m = mdObj.findAllMetrics();
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
    public String addGroup(String id, String metrics) {
    	String[] ary = metrics.split(",");
    	ArrayList<Metric> metricArray = new ArrayList<Metric>();
    	
    	for(int i = 0; i < ary.length; i++){
    		int mId = Integer.parseInt(ary[i]);	
    		metricArray.add(new Metric(mId));
    	}
    	
    	mdObj.addGroup(Integer.parseInt(id), metricArray);
    	
    	return "Success";
    }
    
    @SuppressWarnings({"rawtypes"})
    @POST
    @Path("/addTopic")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String addMetric(String id){ 
    	if(mdObj.addMetric(Integer.parseInt(id)) == true)
    		return "Success";
    	else
    		return "Failure";
    }
    
      
    
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {})
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Response{
		public ArrayList<Group> groups;
		public ArrayList<Metric> metrics;
    }
 
}