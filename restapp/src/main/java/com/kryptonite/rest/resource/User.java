package com.kryptonite.rest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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

import com.kryptonite.constants.AccountType;
import com.kryptonite.constants.Limits;
import com.kryptonite.constants.LoginType;
import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NPRelationships;
import com.kryptonite.constants.NotificationType;
import com.kryptonite.email.NotificationModeEnum;
import com.kryptonite.email.NotificationTypeEnum;
import com.kryptonite.email.RabbitMQPublisher;
import com.kryptonite.rest.model.AchieverModel;
import com.kryptonite.rest.model.EnableRequestModel;
import com.kryptonite.rest.model.EnablerModel;
import com.kryptonite.rest.model.UserModel;
import com.kryptonite.utils.DAO;

@Path("users")
public class User {

	@Inject
	private GraphDatabaseService db;

	@Inject
	private DAO dao;

	@Inject 
	private RabbitMQPublisher rabbitMQPublisher;
	
	@Inject
	Utils utils;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserModel user) {
    	
    	String id = user.getId();

    	try {
			validateNewUserModel(user);
    		Node userNode = dao.getUser(id);
    		
    		if(userNode != null) {
    			return Response.status(400).entity("User already exist: " + id).build();
    		}
    		else {
    	    	try ( Transaction tx = db.beginTx(); ) 
    	    	{
	    			//create new user
		    		userNode = db.createNode();
		    		userNode.setProperty( "id", id.toLowerCase() );
		    		populateUserDetails(userNode,user);
		    		
		    		if(user.getEnablerDetails() != null) {
		    			populateEnablerDetails(userNode, user.getEnablerDetails(),id);
		    		}
		    		
		    		dao.addLabel(id, NPLabels.USER.name());
		    	    tx.success();
		    	    rabbitMQPublisher.publishEvent(user.getEmail(),NotificationModeEnum.EMAIL,NotificationTypeEnum.REGISTRATION,Locale.US);
    			}
    		}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to create user: " + id + " :" + e).build();
    	}
    	
        return Response.status(200).entity("Created user: " + id).build();
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String userId, 
    		UserModel user) {
    	
    	try {
    		Node userNode = dao.getUser(userId);
    		
    		if(userNode != null) {
    			
    			validateUserModel(user);
    			
    	    	try ( Transaction tx = db.beginTx(); ) {
    	    		
	    			populateUserDetails(userNode,user);
	    			
		    		if(user.getEnablerDetails() != null) {
		    			populateEnablerDetails(userNode, user.getEnablerDetails(), userId);
		    		}
		    	    tx.success();
    	    	}
    		}
    		else {
	    		return Response.status(400).entity("User does not exist: " + userId).build();
	    	}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to update user: " + e).build();
    	}
    	
        return Response.status(200).entity("Updated user " + userId).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel getUser(@PathParam("id") String id) {
    	
    	UserModel retVal = null;
    	
    	try {
    		Node userNode = dao.getUser(id.toLowerCase());
    		if(userNode != null) {
    			
    			retVal = new UserModel();
    			retVal.setPassword((String)userNode.getProperty("password"));
    			retVal.setCity((String)userNode.getProperty("city",null));
    			retVal.setCountry((String)userNode.getProperty("country",null));
    			retVal.setFirstName((String)userNode.getProperty("firstname",null));
    			retVal.setGender((String)userNode.getProperty("gender",null));
    			retVal.setLastName((String)userNode.getProperty("lastname",null));
    			retVal.setState((String)userNode.getProperty("state",null));
       			retVal.setZipcode((String)userNode.getProperty("zipcode",null));
       			retVal.setEmail((String)userNode.getProperty("email",null));
       			       			    			
       			String[] imageKeys = (String[])userNode.getProperty("imagekeys",null);
	    		if(imageKeys != null) {
	    			retVal.setImageKeys(Arrays.asList(imageKeys));
	    		}
   				
       			
       			String loginType = (String)userNode.getProperty("logintype",null);
       			if(!StringUtils.isEmpty(loginType)) {
       				retVal.setLoginType(LoginType.valueOf(loginType));
       			}
       			
       			String accountType = (String)userNode.getProperty("accounttype",null);
       			if(!StringUtils.isEmpty(accountType)) {
       				retVal.setAccountType(AccountType.valueOf(accountType));
       			}
       			
   				//users following this user
       			List<String> followerIds = new ArrayList<String>();
       			for(Node n:dao.getFollowers(id)) {
       				followerIds.add((String)n.getProperty("id"));
       			}
   				retVal.setFollowerUserIds(followerIds);
   				
   				//users this user is following
      			List<String> followingUserIds = new ArrayList<String>();
       			for(Node n:dao.getFollowingUsers(id)) {
       				followingUserIds.add((String)n.getProperty("id"));
       			}
   				retVal.setFollowingUserIds(followingUserIds);
 
   				//dreams this user is following
      			List<String> followingDreamIds = new ArrayList<String>();
       			for(Node n:dao.getFollowingDreams(id)) {
       				followingDreamIds.add((String)n.getProperty("id"));
       			}
   				retVal.setFollowingDreamIds(followingDreamIds);

   				//achiever details
   				if(userNode.hasLabel(NPLabels.ACHIEVER)) {
   					AchieverModel achieverDetails = new AchieverModel();
   					
   					//user's dreams
   					List<String> dreamIds = new ArrayList<String>();
   					for(Node dream:dao.getDreamsForAchiever(id)) {
   						dreamIds.add((String)dream.getProperty("id"));
   					}
   					achieverDetails.setDreamIds(dreamIds);
   					retVal.setAchieverDetails(achieverDetails);
   				}
   				
   				//enabler details
   				if(userNode.hasLabel(NPLabels.ENABLER)) {
   					EnablerModel enablerDetails = new EnablerModel();
   					
   					//dreams this user is enabling
   					List<String> dreamIds = new ArrayList<String>();
   					for(Node dream:dao.getDreamsForEnabler(id)) {
   						dreamIds.add((String)dream.getProperty("id"));
   					}
   					enablerDetails.setEnablingDreamIds(dreamIds);
   					
   					//TODO FIx the Preferred Categories issue
   					
   					//String preferredCategories = (String) userNode.getProperty("preferredcategories",null);
   					
   					//String[]categoryList = Arrays.asList(userNode.getProperty("preferredcategories",null)).toArray(new String[preferredCategories.length]);
   					
   					//enablerDetails.setPreferredCategories(categoryList);
   					
   					retVal.setEnablerDetails(enablerDetails);
   				}
   				
   				//enable request sent for this user's dreams
   				List<EnableRequestModel> sentEnableRequestModels = new ArrayList<EnableRequestModel>();
   				Map<String,Relationship> sentEnableRequestRels = dao.getEnableRequestsSentForThisUserDreams(id);
   				for(String dreamId:sentEnableRequestRels.keySet()) {
   					Relationship enableRequestRel = sentEnableRequestRels.get(dreamId);
   					EnableRequestModel enableRequest = new EnableRequestModel();
   					enableRequest.setId((String)enableRequestRel.getProperty("id",null));
   					enableRequest.setDateCreated((String)enableRequestRel.getProperty("creationdate",null));
   					enableRequest.setDateLastUpdated((String)enableRequestRel.getProperty("reqAckDate",null));
   					enableRequest.setReceiverUserId((String)enableRequestRel.getProperty("receiveruserid",null));
   					enableRequest.setDreamId(dreamId);
   					enableRequest.setAccepted((Boolean)enableRequestRel.getProperty("isaccepted",null));
   					enableRequest.setDenied((Boolean)enableRequestRel.getProperty("isdenied",null));
   					sentEnableRequestModels.add(enableRequest);
   				}
   				retVal.setEnableRequestsSentForThisUserDreams(sentEnableRequestModels);
   				
   				//enable request sent for other user's dreams
   				sentEnableRequestModels = new ArrayList<EnableRequestModel>();
   				sentEnableRequestRels = dao.getEnableRequestsSentForOtherUserDreams(id);
   				for(String dreamId:sentEnableRequestRels.keySet()) {
   					Relationship enableRequestRel = sentEnableRequestRels.get(dreamId);
   					EnableRequestModel enableRequest = new EnableRequestModel();
   					enableRequest.setId((String)enableRequestRel.getProperty("id",null));
   					enableRequest.setDateCreated((String)enableRequestRel.getProperty("creationdate",null));
   					enableRequest.setDateLastUpdated((String)enableRequestRel.getProperty("reqAckDate",null));
   					enableRequest.setReceiverUserId((String)enableRequestRel.getProperty("receiveruserid",null));
   					enableRequest.setDreamId(dreamId);
   					enableRequest.setAccepted((Boolean)enableRequestRel.getProperty("isaccepted",null));
   					enableRequest.setDenied((Boolean)enableRequestRel.getProperty("isdenied",null));
   					sentEnableRequestModels.add(enableRequest);
   				}
   				retVal.setEnableRequestsSentForOtherUserDreams(sentEnableRequestModels);
   				
   				//enable request received for this user's dreams
   				List<EnableRequestModel> receivedEnableRequestModels = new ArrayList<EnableRequestModel>();
   				Map<String,Relationship> receivedEnableRequestRels = dao.getEnableRequestsReceivedForThisUserDreams(id);
   				for(String dreamId:receivedEnableRequestRels.keySet()) {
   					Relationship enableRequestRel = receivedEnableRequestRels.get(dreamId);
   					EnableRequestModel enableRequest = new EnableRequestModel();
   					enableRequest.setId((String)enableRequestRel.getProperty("id",null));
   					enableRequest.setDateCreated((String)enableRequestRel.getProperty("creationdate",null));
   					enableRequest.setDateLastUpdated((String)enableRequestRel.getProperty("lastupdatedate",null));
   					enableRequest.setSenderUserId((String)enableRequestRel.getProperty("senderuserid",null));
   					enableRequest.setDreamId(dreamId);
   					enableRequest.setAccepted((Boolean)enableRequestRel.getProperty("isaccepted",null));
   					enableRequest.setDenied((Boolean)enableRequestRel.getProperty("isdenied",null));
   					receivedEnableRequestModels.add(enableRequest);
   				}
   				retVal.setEnableRequestsReceivedForThisUserDreams(receivedEnableRequestModels);
   				
   				//enable request received for other user's dreams
   				receivedEnableRequestModels = new ArrayList<EnableRequestModel>();
   				receivedEnableRequestRels = dao.getEnableRequestsReceivedForOtherUserDreams(id);
   				for(String dreamId:receivedEnableRequestRels.keySet()) {
   					Relationship enableRequestRel = receivedEnableRequestRels.get(dreamId);
   					EnableRequestModel enableRequest = new EnableRequestModel();
   					enableRequest.setId((String)enableRequestRel.getProperty("id",null));
   					enableRequest.setDateCreated((String)enableRequestRel.getProperty("creationdate",null));
   					enableRequest.setDateLastUpdated((String)enableRequestRel.getProperty("lastupdatedate",null));
   					enableRequest.setSenderUserId((String)enableRequestRel.getProperty("senderuserid",null));
   					enableRequest.setDreamId(dreamId);
   					enableRequest.setAccepted((Boolean)enableRequestRel.getProperty("isaccepted",null));
   					enableRequest.setDenied((Boolean)enableRequestRel.getProperty("isdenied",null));
   					receivedEnableRequestModels.add(enableRequest);
   				}
   				retVal.setEnableRequestsReceivedForOtherUserDreams(receivedEnableRequestModels);
    		}
    		else {
    			throw new WebApplicationException(Response.status(404).entity("User not found: " + id).build());
    		}
    	}
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get user: " + e).build());
    	}
    	
    	return retVal;
    }
	
	private void validateNewUserModel(UserModel userModel) {
		
		if(userModel.getLoginType() == null) {
			throw new IllegalArgumentException("Login type is required");
		}
		
		if(StringUtils.isEmpty(userModel.getId())) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}

		if(StringUtils.isEmpty(userModel.getEmail())) {
			throw new IllegalArgumentException("Email Id cannot be empty");
		}

		if(userModel.getLoginType().equals(LoginType.NP)) {
			if(StringUtils.isEmpty(userModel.getPassword())) {
				throw new IllegalArgumentException("User password cannot be empty");
			}
		}
		
		if(!((userModel.getAccountType().equals(AccountType.ACHIVER)) || (userModel.getAccountType().equals(AccountType.ENABLER)))) {
			throw new IllegalArgumentException("AccountType is not correct");
		}
		
		validateUserModel(userModel);
	}
		
	private void validateUserModel(UserModel userModel) {
		
		if(userModel.getFollowingUserIds() != null) {
			
			List<Node> followingUserNodes = new ArrayList<Node>();
			
			for(String userIdToFollow:userModel.getFollowingUserIds()) {
				
				Node userToFollowNode = dao.getUser(userIdToFollow);
	
				if(userToFollowNode == null) {
					throw new IllegalStateException("User Id to follow " + userIdToFollow + " does not exist");
				}
				else {
					followingUserNodes.add(userToFollowNode);
				}
			}
			userModel.setFollowingUserNodes(followingUserNodes);
		}
		
		if(userModel.getFollowingDreamIds() != null) {
			
			List<Node> followingDreamNodes = new ArrayList<Node>();
			
			for(String dreamIdToFollow:userModel.getFollowingDreamIds()) {
				
				Node dreamToFollowNode = dao.getDream(dreamIdToFollow);
	
				if(dreamToFollowNode == null) {
					throw new IllegalStateException("Dream Id to follow " + dreamIdToFollow + " does not exist");
				}
				else {
					followingDreamNodes.add(dreamToFollowNode);
				}
			}
			userModel.setFollowingDreamNodes(followingDreamNodes);
		}
	}
	
	private void populateUserDetails(Node userNode, UserModel user) {

		if(!StringUtils.isEmpty(user.getPassword())) {
			//userNode.setProperty( "password", user.getPassword() );
			userNode.setProperty( "password", "t-fly.com" );
		}
		if(!StringUtils.isEmpty(user.getCity())) {
			userNode.setProperty("city", user.getCity());
		}
		if(!StringUtils.isEmpty(user.getCountry())) {
			userNode.setProperty("country", user.getCountry());
		}
		if(!StringUtils.isEmpty(user.getFirstName())) {
			userNode.setProperty("firstname", user.getFirstName());
		}
		if(!StringUtils.isEmpty(user.getGender())) {
			userNode.setProperty("gender", user.getGender());
		}
		if(!StringUtils.isEmpty(user.getLastName())) {
			userNode.setProperty("lastname", user.getLastName());
		}
		if(!StringUtils.isEmpty(user.getState())) {
			userNode.setProperty("state", user.getState());
		}
		if(!StringUtils.isEmpty(user.getZipcode())) {
			userNode.setProperty("zipcode", user.getZipcode());
		}
		if(!StringUtils.isEmpty(user.getEmail())) {
			userNode.setProperty("email", user.getEmail());
		}
		if(user.getLoginType() != null) {
			userNode.setProperty("logintype", user.getLoginType().name());
		}
		if(user.getAccountType() != null) {
			userNode.setProperty("accounttype", user.getAccountType().name());
		}
		
		if(user.getFollowingUserNodes() != null) {
			for(Node userNodeToFollow:user.getFollowingUserNodes()) {
				Relationship r = userNode.createRelationshipTo(userNodeToFollow, NPRelationships.FOLLOWING);
				String followId = "foll" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
				r.setProperty("id", followId);
				r.setProperty("followeruserid", userNode.getProperty("id"));
				String followingUserId = (String)userNodeToFollow.getProperty("id");
				r.setProperty("followinguserid", followingUserId);
				r.setProperty("creationdate", new Date().toString());
				
				//follow user notification
				utils.addNotification(NotificationType.FOLLOW_USER, 
						followId, 
						followingUserId);
				}
		}

		if(user.getFollowingDreamNodes() != null) {
			for(Node dreamNodeToFollow:user.getFollowingDreamNodes()) {
				Relationship r = userNode.createRelationshipTo(dreamNodeToFollow, NPRelationships.FOLLOWING);
				String followId = "foll" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
				r.setProperty("id", followId);
				r.setProperty("followeruserid", userNode.getProperty("id"));
				r.setProperty("followingdreamid", dreamNodeToFollow.getProperty("id"));
				r.setProperty("creationdate", new Date().toString());
				
				//follow dream notification
				utils.addNotification(NotificationType.FOLLOW_DREAM, 
						followId, 
						(String)dreamNodeToFollow.getProperty("userid"));
			}
		}
		
	
		
		if(user.getImageKeys() != null) {	
			String[] currentImageLinks = (String[])userNode.getProperty("imagelinks",null);
			
			if(currentImageLinks != null) {
				if(currentImageLinks.length + user.getImageKeys().size() > Limits.MAX_NUM_IMAGES) {
					throw new IllegalArgumentException("Max number of Images exceeded");
				}
				user.getImageKeys().addAll(Arrays.asList(currentImageLinks));
			}
			
			userNode.setProperty("imagekeys", user.getImageKeys());
		}
		
	}
	   
	private void populateEnablerDetails(Node user, EnablerModel enabler, String id) {

		if(enabler.getPreferredCategories() != null) {
			user.setProperty("preferredcategories", enabler.getPreferredCategories());
		}
	}
}
