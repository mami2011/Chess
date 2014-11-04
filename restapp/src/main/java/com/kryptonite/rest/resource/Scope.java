package com.kryptonite.rest.resource;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import com.kryptonite.constants.NPLabels;
import com.kryptonite.rest.model.EnableScopeModel;
import com.kryptonite.utils.DAO;

@Path("scope")
public class Scope {
	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	 public Response createEnableScope(EnableScopeModel scope) {
	    	
			String id = null;

			try {
	    		validateNewScope(scope);

	    		try ( Transaction tx = db.beginTx(); )
		    	{
		       		id = NPLabels.SCOPE.name() + Math.abs(UUID.randomUUID().getLeastSignificantBits());
		    		Node scopeNode = db.createNode();
		    		scopeNode.setProperty( "id", id );
		    		populateScopeNode(scopeNode,scope);
	    			dao.addLabel(id, NPLabels.SCOPE.name());	    			
		    	    tx.success();
		    	}
	    	}
	    	catch(Exception e) {
	    		return Response.status(500).entity("Unable to create Scope: " + e).build();
	    	}
	    	
	        return Response.status(200).entity("Created Scope " + id).build();
	    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEnableScope(@PathParam("id") String scopeId, EnableScopeModel enableScopeModel) {
    	
    	try
    	{
    		Node scopeNode = dao.getEnablerScopes(scopeId);
    		enableScopeModel.setId(scopeId);
    		
    		if(scopeNode != null) {
    			validateExistingScope(enableScopeModel);
    	    	try ( Transaction tx = db.beginTx(); )
    	    	{
    	    		populateScopeNode(scopeNode,enableScopeModel);	    		
    	    		tx.success();
    	    	}
    		}
       		else {
	    		return Response.status(400).entity("Enable Scope does not exist: " + scopeId).build();
	    	}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to update Scope: " + e).build();
    	}
    	
        return Response.status(200).entity("Updated Scope " + scopeId).build();
    }
    
    @GET
    @Path("{scopeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnableScopeModel getDream(@PathParam("scopeId") String scopeId) {
    	
    	EnableScopeModel scope = null;

    	try {
    		Node scopeNode = dao.getEnablerScopes(scopeId);
    		
    		scope = populateScopeModel(scopeId, scopeNode);
    	}
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get Enabler Scope: " + e).build());
    	}
    	
    	return scope;
    }

	private EnableScopeModel populateScopeModel(String scopeId, Node scopeNode) {
		EnableScopeModel scope = new EnableScopeModel();
		scope.setId(scopeId);
		scope.setName((String) scopeNode.getProperty("name")); 
		scope.setAchieverScopeText((String) scopeNode.getProperty("achieverScopeText")); 
		scope.setEnablerScopeText((String) scopeNode.getProperty("enablerScopeText")); 
		scope.setDateCreated((String) scopeNode.getProperty("dateCreated")); 
		scope.setDateLastUpdated((String) scopeNode.getProperty("dateLastUpdated")); 	
		return scope;
	}

	private void populateScopeNode(Node scopeNode, EnableScopeModel scope) {
		scopeNode.setProperty("name", scope.getName());
		scopeNode.setProperty("achieverScopeText", scope.getAchieverScopeText());
		scopeNode.setProperty("enablerScopeText", scope.getEnablerScopeText());
		scopeNode.setProperty("dateCreated", (new Date()).toString());
		scopeNode.setProperty("dateLastUpdated", (new Date()).toString());
	}

	private void validateNewScope(EnableScopeModel scope) {
		if(StringUtils.isEmpty(scope.getName())) {
			throw new IllegalArgumentException("Enabling Scope name is required");
		}	
		if(StringUtils.isEmpty(scope.getAchieverScopeText())) {
			throw new IllegalArgumentException("Achiever's Scope View text is required");
		}	
		if(StringUtils.isEmpty(scope.getEnablerScopeText())) {
			throw new IllegalArgumentException("Enabler's Scope View text is required");
		}	
		
		List<Node> scopeNodeList = dao.getEnablerScopes(scope.getName(), scope.getAchieverScopeText(),scope.getEnablerScopeText());
		
		if(scopeNodeList.size() > 0)
		{
				throw new IllegalArgumentException("Scope with entered details already exists");

		}
	}

	private void validateExistingScope(EnableScopeModel scope) {
		List<Node> scopeNodeList = dao.getEnablerScopes(scope.getName(), scope.getAchieverScopeText(),scope.getEnablerScopeText());
		
		if( scopeNodeList.size() > 0)
		{
				throw new IllegalArgumentException("Scope with entered details exists already");

		}
	}    

}
