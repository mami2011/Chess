package com.kryptonite.rest.resource;

import java.util.ArrayList;
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
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NotificationType;
import com.kryptonite.rest.model.CommentModel;
import com.kryptonite.rest.model.EnableRequestModel;
import com.kryptonite.rest.model.FollowModel;
import com.kryptonite.rest.model.LikeModel;
import com.kryptonite.rest.model.NotificationModel;
import com.kryptonite.utils.DAO;

@Path("notifications")
public class Notification {
	
	@Inject
	GraphDatabaseService db;
	
	@Inject
	DAO dao;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNotification(NotificationModel notification) {
    	
    	String id = null;
    	
    	validateNewNotification(notification);
    	
    	try ( Transaction tx = db.beginTx(); )
		{
			//create new notification
			Node notificationNode = db.createNode();
			id = "not" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
			notificationNode.setProperty("id", id);
			notificationNode.setProperty("type", notification.getType().name());
			notificationNode.setProperty("typeid",notification.getTypeId());
			notificationNode.setProperty("userid",notification.getUserId());
			notificationNode.setProperty("acked",false);
			dao.addLabel(id, NPLabels.NOTIFICATION.name());
			tx.success();
		}
		catch(Exception e) {
			return Response.status(500).entity("Unable to create notification: " + e).build();
		}

    	return Response.status(200).entity("Created notification " + id).build();
    }
    
    @GET
	@Path("/ack/{id}")
	public Response ackNotification(@PathParam("id") String notificationId) {
    	
    	Node notificationNode = dao.getNotificationById(notificationId);
    	
		if(notificationNode != null) {

			try ( Transaction tx = db.beginTx(); )
			{
				notificationNode.setProperty("acked", true);
				tx.success();
			}
			catch(Exception e) {
				return Response.status(500).entity("Unable to update notification: " + e).build();
			}
		}
		else {
			return Response.status(400).entity("Notification does not exist: " + notificationId).build();
		}

		return Response.status(200).entity("Acked notification " + notificationId).build();
    }
    
    private void validateNewNotification(NotificationModel notification) {
    	
    	if(StringUtils.isEmpty(notification.getUserId())) {
			throw new IllegalArgumentException("User id is required");
		}
    	
    	if(notification.getType() == null) {
			throw new IllegalArgumentException("Notification type is required");
		}
    	
    	if(notification.getAcked()) {
			throw new IllegalArgumentException("New notification cannot be acked by default");
		}
    	
    	if(StringUtils.isEmpty(notification.getTypeId())) {
			throw new IllegalArgumentException("Notification type id is required");
		}
    }
    
    @GET
	@Path("{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotificationModel> getNewNotificationsForUser(@PathParam("userid") String userId) {
    	
    	if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
    	
    	List<NotificationModel> retVal = new ArrayList<>();

		try {
			List<Node> notificationNodes = dao.getNewNotificationsForUser(userId);

			for(Node notificationNode:notificationNodes) {
				retVal.add(getNotificationModel(notificationNode));
			}
		}
		catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get notification for user id: " + userId).build());
		}

		return retVal;
	}
    
    private NotificationModel getNotificationModel(Node notificationNode) {
    	
    	NotificationModel notification = new NotificationModel();
    	String userId = (String)notificationNode.getProperty("userid");
    	notification.setId((String)notificationNode.getProperty("id"));
    	NotificationType notificationType = NotificationType.valueOf((String)notificationNode.getProperty("type"));
    	notification.setType(notificationType);
    	String typeId = (String)notificationNode.getProperty("typeid");
    	
    	switch(notificationType) {
    	case COMMENT:
    		Relationship comment = dao.getCommentById(typeId, userId);
    		if(comment != null) {
	    		CommentModel commentModel = new CommentModel();
	    		commentModel.setComment((String)comment.getProperty("comment"));
	    		commentModel.setCommenterUserId((String)comment.getProperty("commenteruserid"));
	    		commentModel.setCreationDate((String)comment.getProperty("creationdate"));
	    		notification.setNotifiableModel(commentModel);
    		}
    		break;
    	case LIKE:
    		Relationship like = dao.getLikeById(typeId, userId);
    		if(like != null) {
	    		LikeModel likeModel = new LikeModel();
	    		likeModel.setLikerUserId((String)like.getProperty("likeruserid"));
	    		likeModel.setCreationDate((String)like.getProperty("creationdate"));
	    		likeModel.setIsValid((boolean)like.getProperty("isvalid"));
	    		notification.setNotifiableModel(likeModel);
    		}
    		break;
    	case ENABLE_REQUEST_RECV:
    		Relationship receivedEnableRequest = dao.getEnableRequest(typeId);
    		if(receivedEnableRequest != null) {
    			EnableRequestModel enableRequestRecvModel = new EnableRequestModel();
    			enableRequestRecvModel.setId((String)receivedEnableRequest.getProperty("id"));
    			enableRequestRecvModel.setDateCreated((String)receivedEnableRequest.getProperty("creationdate"));
    			enableRequestRecvModel.setDreamId((String)receivedEnableRequest.getProperty("dreamid"));
    			enableRequestRecvModel.setSenderUserId((String)receivedEnableRequest.getProperty("senderuserid"));
    			notification.setNotifiableModel(enableRequestRecvModel);
    		}
    		break;
    	case ENABLE_REQUEST_ACCEPT:
    		Relationship acceptedEnableRequest = dao.getEnableRequest(typeId);
    		if(acceptedEnableRequest != null) {
    			EnableRequestModel enableRequestAcceptModel = new EnableRequestModel();
    			enableRequestAcceptModel.setId((String)acceptedEnableRequest.getProperty("id"));
    			enableRequestAcceptModel.setDreamId((String)acceptedEnableRequest.getProperty("dreamid"));
    			enableRequestAcceptModel.setReceiverUserId((String)acceptedEnableRequest.getProperty("receiveruserid"));
    			enableRequestAcceptModel.setDateLastUpdated((String)acceptedEnableRequest.getProperty("reqackdate"));
    			notification.setNotifiableModel(enableRequestAcceptModel);
    		}
    		break;
    	case ENABLE_REQUEST_DENY:
    		Relationship deniedEnableRequest = dao.getEnableRequest(typeId);
    		if(deniedEnableRequest != null) {
    			EnableRequestModel enableRequestAcceptModel = new EnableRequestModel();
    			enableRequestAcceptModel.setId((String)deniedEnableRequest.getProperty("id"));
    			enableRequestAcceptModel.setDreamId((String)deniedEnableRequest.getProperty("dreamid"));
    			enableRequestAcceptModel.setReceiverUserId((String)deniedEnableRequest.getProperty("receiveruserid"));
    			enableRequestAcceptModel.setDateLastUpdated((String)deniedEnableRequest.getProperty("reqackdate"));
    			notification.setNotifiableModel(enableRequestAcceptModel);
    		}
    		break;
    	case FOLLOW_USER:
    		Relationship userFollower = dao.getFollowerById(typeId);
    		if(userFollower != null) {
	    		FollowModel followModel = new FollowModel();
	    		followModel.setFollowerUserId((String)userFollower.getProperty("followeruserid"));
	    		followModel.setCreationDate((String)userFollower.getProperty("creationdate"));
	    		notification.setNotifiableModel(followModel);
    		}
    		break;
		case FOLLOW_DREAM:
			Relationship dreamFollower = dao.getFollowerById(typeId);
			if(dreamFollower != null) {
	    		FollowModel followModel = new FollowModel();
	    		followModel.setFollowerUserId((String)dreamFollower.getProperty("followeruserid"));
	    		followModel.setDreamId((String)dreamFollower.getProperty("followingdreamid"));
	    		followModel.setCreationDate((String)dreamFollower.getProperty("creationdate"));
	    		notification.setNotifiableModel(followModel);
			}
		}
    	return notification;
    }

}
