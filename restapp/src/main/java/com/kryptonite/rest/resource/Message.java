package com.kryptonite.rest.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.kryptonite.rest.model.MessageModel;
import com.kryptonite.utils.DAO;

@Path("messages")
public class Message {

	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMessage(MessageModel message) {

		String id = null;

		if(StringUtils.isEmpty(message.getDreamId())) {
			throw new IllegalArgumentException("Dream id is required");
		}

		validateMessageModel(message);

		try ( Transaction tx = db.beginTx(); )
		{
			//create new message
			Node messageNode = db.createNode();
			id = "mes" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
			messageNode.setProperty("id", id);
			messageNode.setProperty("creationdate", (new Date()).toString());
			populateMessageNode(messageNode,message);
			dao.addLabel(id, NPLabels.MESSAGE.name());
			tx.success();

			
		}
		catch(Exception e) {
			return Response.status(500).entity("Unable to create Message: " + e).build();
		}

		return Response.status(200).entity("Created message " + id).build();
	}

	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("id") String messageId, 
			MessageModel message) {

		String id = messageId;
		validateMessageModel(message);

		Node messageNode = dao.getMessageById(id);
		if(messageNode != null) {

			try ( Transaction tx = db.beginTx(); )
			{
				populateMessageNode(messageNode,message);
				tx.success();
			}
			catch(Exception e) {
				return Response.status(500).entity("Unable to update message: " + e).build();
			}
		}
		else {
			return Response.status(400).entity("Message does not exist: " + messageId).build();
		}

		return Response.status(200).entity("Updated message " + id).build();
	}

	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel getMessage(@PathParam("id") String id) {

		MessageModel message = new MessageModel();

		try {
			Node messageNode = dao.getMessageById(id);

			if(messageNode != null) {
				message.setId((String) messageNode.getProperty("id"));
				message.setDreamId((String) messageNode.getProperty("dreamid"));
				message.setUserId((String) messageNode.getProperty("userid"));
				message.setType((String) messageNode.getProperty("type"));
				message.setTypeId((String) messageNode.getProperty("typeid"));
			}
			else {
				throw new WebApplicationException(Response.status(404).entity("Message not found: " + id).build());
			}
		}
		catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get Message: " + id).build());
		}

		return message;
	}

	@GET
	@Path("/user/{userid}/unreadcount")
	@Produces(MediaType.APPLICATION_JSON)
	public int getUnreadMessageCountByUser(@PathParam("userid") String userId) {

		int retVal = 0;

    	try {
    		retVal = dao.getUnreadMessageCountByUserId(userId);
    		
    		
    	}
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get unread message count for userid: " + userId).build());
    	}
    	
    	return retVal;
	}

	@GET
	@Path("/user/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageModel> getMessagesByUser(@PathParam("userid") String userId) {

		List<MessageModel> retVal = new ArrayList<>();
		
		try {
		List<Node> messageNodes = dao.getMessagesByUserId(userId);

			for(Node messageNode:messageNodes) {
				if (messageNode != null )
				retVal.add(getMessageModel(messageNode));
			}
		}
	    	
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get  messages  for userid: " + userId).build());
    	}
    	
    	return retVal;
	}

	
	
	private void validateMessageModel(MessageModel message) {

		
	}

	private void populateMessageNode(Node messageNode , MessageModel message) {

		if(!StringUtils.isEmpty(message.getDreamId())) {
			messageNode.setProperty( "dreamid", message.getDreamId() );	
		}
		if(!StringUtils.isEmpty(message.getType())) {
			messageNode.setProperty( "type", message.getType() );
		}
		if(!StringUtils.isEmpty(message.getTypeId())) {
			messageNode.setProperty( "typeid", message.getTypeId() );
		}
		if(!StringUtils.isEmpty(message.getUserId())) {
			messageNode.setProperty( "userid", message.getUserId() );
		}
		if(!StringUtils.isEmpty(message.getMessage())) {
			messageNode.setProperty( "message", message.getMessage() );
		}
		if(!StringUtils.isEmpty(message.getSenderId())) {
			messageNode.setProperty( "senderid", message.getSenderId() );
		}
		messageNode.setProperty( "isread", message.getIsRead() );
				
	}
	
private MessageModel getMessageModel(Node messageNode) {
    	MessageModel message = new MessageModel();
    	String userId = (String)messageNode.getProperty("userid");
    	message.setUserId(userId);
    	message.setId((String)messageNode.getProperty("id"));
    	String dreamId = (String)messageNode.getProperty("dreamid");
    	message.setDreamId(dreamId);
    	String msg = (String)messageNode.getProperty("message");
    	message.setMessage(msg);
    	String senderId = (String)messageNode.getProperty("senderid");
    	message.setSenderId(senderId);    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");     
    	Date creationDate = null;
		try {
			creationDate = dateFormat.parse((String)messageNode.getProperty("creationdate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	message.setCreationDate(creationDate);
    	boolean isRead = (boolean)messageNode.getProperty("isread");
    	message.setRead(isRead);
    	return message;
    }

}
