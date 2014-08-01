package com.kryptonite.rest.resource;

import java.util.Date;
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
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NPRelationships;
import com.kryptonite.constants.NotificationType;
import com.kryptonite.rest.model.EnableRequestModel;
import com.kryptonite.utils.DAO;

@Path("enablerequests")
public class EnableRequest {

	@Inject
	GraphDatabaseService db;
	
	@Inject
	DAO dao;
	
	@Inject
	Utils utils;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEnableRequest(EnableRequestModel enableRequest) {
    	
    	String id = null;

    	try {
			validateEnableRequestModel(enableRequest);
    		
	    	try ( Transaction tx = db.beginTx(); ) 
	    	{	
	    		Relationship r = null;
	    		
	    		if(Boolean.valueOf(enableRequest.isSentFromAchiever())) {
	    			r = enableRequest.getDreamNode().createRelationshipTo(enableRequest.getUserNode(), 
		    				NPRelationships.ENABLE_REQUESTED);
	    		}
	    		else {
	    			r = enableRequest.getUserNode().createRelationshipTo(enableRequest.getDreamNode(), 
		    				NPRelationships.ENABLE_REQUESTED);
	    		}
	    		
	    		r.setProperty("creationdate", new Date().toString());
	    		r.setProperty("id", id = enableRequest.getDreamId() 
	    				+ Math.abs(UUID.randomUUID().getLeastSignificantBits()));
	    		r.setProperty("dreamid", enableRequest.getDreamId());
	    		r.setProperty("senderuserid", enableRequest.getSenderUserId());
	    		r.setProperty("receiveruserid", enableRequest.getReceiverUserId());
	    		
	    		//enable request received notification
	    		utils.addNotification(NotificationType.ENABLE_REQUEST_RECV, 
	    				id, 
	    				enableRequest.getReceiverUserId());
	    		
	    		tx.success();
    		}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to create enable request: " + e).build();
    	}
    	
        return Response.status(200).entity("Created enable request " + id).build();
    	
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String enableRequestId, 
    		EnableRequestModel enableRequest) {
    	
    	try {
    		Relationship enableRequestRel = dao.getEnableRequest(enableRequestId);
    		
    		if(enableRequestRel != null) {
    			
    			validateExistingEnableRequestModel(enableRequest, enableRequestRel);
    			
    	    	try ( Transaction tx = db.beginTx(); ) {

    	    		if(enableRequest.isAccepted() != null &&
    	    				enableRequest.isAccepted()) {
    	    			enableRequestRel.setProperty("isaccepted", true);
    	    			Relationship enablingRel = enableRequest.getUserNode()
    	    					.createRelationshipTo(enableRequest.getDreamNode(), NPRelationships.ENABLING);
    	    			
    	    			if(Boolean.valueOf(enableRequest.isSentFromAchiever())) {
    	    				dao.addLabel(enableRequest.getReceiverUserId(), NPLabels.ENABLER.name());
    	    			}
    	    			else {
    	    				dao.addLabel(enableRequest.getSenderUserId(), NPLabels.ENABLER.name());
    	    			}
    	    			
    	    			enablingRel.setProperty("reqackdate", new Date().toString());
    	    			
    	    			//enable request accepted notification
    	    			utils.addNotification(NotificationType.ENABLE_REQUEST_ACCEPT, 
    	    					enableRequestId, 
    	    					enableRequest.getSenderUserId());
    	    		}
    	    		else if(enableRequest.isDenied() != null &&
    	    				enableRequest.isDenied()) {
    	    			enableRequestRel.setProperty("isdenied", true);
    	    			
    	    			//enable request denied notification
    	    			utils.addNotification(NotificationType.ENABLE_REQUEST_DENY, 
    	    					enableRequestId, 
    	    					enableRequest.getSenderUserId());
    	    		}
	    			enableRequestRel.setProperty("reqackdate", new Date().toString());
 		    	    tx.success();
    	    	}
    		}
    		else {
	    		return Response.status(400).entity("Enable request does not exist: " + enableRequestId).build();
	    	}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to update enable request: " + e).build();
    	}
    	
        return Response.status(200).entity("Updated enable request: " + enableRequestId).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnableRequestModel getEnableRequest(@PathParam("id") String enableRequestId) {
    	
    	EnableRequestModel enableRequest = new EnableRequestModel();

    	try {
    		Relationship r = dao.getEnableRequest(enableRequestId);
    		
    		if(r != null) {
    			enableRequest.setAccepted((boolean)r.getProperty("isaccepted",false));
    			enableRequest.setDenied((boolean)r.getProperty("isdenied",false));
    			enableRequest.setDateLastUpdated((String)r.getProperty("lastupdatedate",null));
    			enableRequest.setDateCreated((String)r.getProperty("creationdate",null));
    			//enableRequest.setSentFromAchiever((boolean)r.getProperty("issentfromachiever",null));
    		}
			else {
					throw new WebApplicationException(Response.status(404).entity("Enable request not found: " + enableRequestId).build());
			}
		}
		catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get enable request: " + e).build());
		}

    	return enableRequest;
	}
    
    private void validateEnableRequestModel(EnableRequestModel enableRequest) {
    	
		if(StringUtils.isEmpty(enableRequest.getDreamId())) {
			throw new IllegalArgumentException("Dream Id is required");
		}
		
		if(StringUtils.isEmpty(enableRequest.getSenderUserId())) {
			throw new IllegalArgumentException("Sender User Id is required");
		}
		
		if(StringUtils.isEmpty(enableRequest.getReceiverUserId())) {
			throw new IllegalArgumentException("Receiver User Id is required");
		}
		
		Node dreamNode = dao.getDream(enableRequest.getDreamId());
		
		if(dreamNode == null) {
			throw new IllegalArgumentException("Dream Id not found:" + enableRequest.getDreamId());
		}
		
		enableRequest.setDreamNode(dreamNode);
		
		String userId = null;
		//if sender is the owner of the dream, get the receiver user node
		if(enableRequest.getSenderUserId().equals(dreamNode.getProperty("userid",null))) {
			userId = enableRequest.getReceiverUserId();
			enableRequest.setSentFromAchiever(true);
		}
		else {	//sender is a another user
			userId = enableRequest.getSenderUserId();
			enableRequest.setSentFromAchiever(false);
		}
		
		Node userNode = dao.getUser(userId);

		if(userNode == null) {
			throw new IllegalArgumentException("User Id not found:" + userId);
		}
		enableRequest.setUserNode(userNode);
    }
    
    private void validateExistingEnableRequestModel(EnableRequestModel enableRequestModel, Relationship enableRequest) {
    	
    	enableRequestModel.setDreamId((String)enableRequest.getProperty("dreamid"));
    	enableRequestModel.setSenderUserId((String)enableRequest.getProperty("senderuserid"));
    	enableRequestModel.setReceiverUserId((String)enableRequest.getProperty("receiveruserid"));
    	
    	validateEnableRequestModel(enableRequestModel);
    	
    	if((boolean)enableRequest.getProperty("isaccepted",false) || 
    			(boolean)enableRequest.getProperty("isdenied",false)) {
    		throw new IllegalArgumentException("Enable request is already accepted/declined");
    	}
    	
		if(enableRequestModel.isAccepted() == null &&
				enableRequestModel.isDenied() == null) {
			throw new IllegalArgumentException("Enable request accept/denied is required");
		}
		
		if(enableRequestModel.isAccepted() != null &&
				enableRequestModel.isDenied() != null) {
			throw new IllegalArgumentException("Enable request cannot be accepted and denied");
		}
    }
}
