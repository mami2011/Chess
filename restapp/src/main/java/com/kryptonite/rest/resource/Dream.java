package com.kryptonite.rest.resource;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import com.kryptonite.constants.Limits;
import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NPRelationships;
import com.kryptonite.constants.NotificationType;
import com.kryptonite.rest.model.CommentModel;
import com.kryptonite.rest.model.DreamModel;
import com.kryptonite.rest.model.LikeModel;
import com.kryptonite.utils.DAO;

@Path("dreams")
public class Dream {

	@Inject
	GraphDatabaseService db;
	
	@Inject
	DAO dao;
	
	@Inject
	Utils utils;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDream(DreamModel dream) {
    	
		String id = null;

		try {
    		validateNewDreamModel(dream);

    		try ( Transaction tx = db.beginTx(); )
	    	{
	       		id = dream.getAchieverUserId() + Math.abs(UUID.randomUUID().getLeastSignificantBits());
	    		Node dreamNode = db.createNode();
	    		dreamNode.setProperty( "id", id );
	    		dreamNode.setProperty("name", dream.getName());
    			dreamNode.setProperty("userid", dream.getAchieverUserId());
	    		dreamNode.setProperty("creationdate", (new Date()).toString());
	    		populateDreamNode(dreamNode,dream);
    			dao.addLabel(id, NPLabels.DREAM.name());
    			dao.addLabel(dream.getAchieverUserId(), NPLabels.ACHIEVER.name());
    			
	    	    tx.success();
	    	}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to create dream: " + e).build();
    	}
    	
        return Response.status(200).entity("Created dream " + id).build();
    }

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDream(@PathParam("id") String dreamId, 
    		DreamModel dream) {
    	
    	try
    	{
    		Node dreamNode = dao.getDream(dreamId);
    		dream.setId(dreamId);
    		
    		if(dreamNode != null) {
    			validateExistingDreamModel(dream);
    	    	try ( Transaction tx = db.beginTx(); )
    	    	{
    	    		populateDreamNode(dreamNode,dream);
    	    		
    	    		//add/remove comments
    	    		if(dream.getComments() != null) {
    	    			for(CommentModel comment:dream.getComments()) {
    	    				
    	    				if(comment.isValid()) {
	    	    				Relationship r = comment.getCommenterUserNode()
	    	    						.createRelationshipTo(dreamNode, NPRelationships.COMMENTED);
	    	    				String commentId = "com" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
	    	    				r.setProperty("id", commentId);
	    	    				r.setProperty("creationdate", new Date().toString());
	    	    				r.setProperty("commenteruserid", comment.getCommenterUserId());
	    	    				r.setProperty("comment", comment.getComment());
	    	    				r.setProperty("dreamid", comment.getDreamId());
	    	    				if(comment.getParentCommentId() != null) {
	    	    					r.setProperty("parentcommentid", comment.getParentCommentId());
	    	    				}
	    	    				r.setProperty("isvalid", true);
	    	    				
	    	    				//comment notification
	    	    				utils.addNotification(NotificationType.COMMENT, 
	    	    						commentId, 
	    	    						(String)dreamNode.getProperty("userid"));
    	    				}
    	    				else {	//remove comment
    	    					comment.getCommentRelationship().setProperty("isvalid", false);
    	    				}
    	    			}
    	    		}
    	    		
    	    		//like/unlike
    	    		if(dream.getLikers() != null) {
    	    			for(LikeModel like:dream.getLikers()) {
    	    				
    	    				if(like.isValid()) {
	    	    				Relationship r = like.getLikerUserNode()
	    	    						.createRelationshipTo(dreamNode, NPRelationships.LIKED);
	    	    				String likeId = "like" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
	    	    				r.setProperty("id", likeId);
	    	    				r.setProperty("creationdate", new Date().toString());
	    	    				r.setProperty("likeruserid", like.getLikerUserId());
	    	    				r.setProperty("isvalid", true);
	    	    				r.setProperty("dreamid", like.getDreamId());
	    	    				
	    	    				//like notification
	    	    				utils.addNotification(NotificationType.LIKE, 
	    	    						likeId, 
	    	    						(String)dreamNode.getProperty("userid"));
    	    				}
    	    				else {	//unlike
    	    					like.getLikeRelationship().setProperty("isvalid", false);
    	    				}
    	    			}
    	    		}

    	    		tx.success();
    	    	}
    		}
       		else {
	    		return Response.status(400).entity("Dream does not exist: " + dreamId).build();
	    	}
    	}
    	catch(Exception e) {
    		return Response.status(500).entity("Unable to update dream: " + e).build();
    	}
    	
        return Response.status(200).entity("Updated dream " + dreamId).build();
    }
    
    @GET
    @Path("{dreamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public DreamModel getDream(@PathParam("dreamId") String dreamId) {
    	
    	DreamModel dream = new DreamModel();

    	try {
    		Node dreamNode = dao.getDream(dreamId);
    		
    		dream = populateDreamModel(dreamNode);
    	}
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get dream: " + e).build());
    	}
    	
    	return dream;
    }

	/**
	 * @param dreamId
	 * @param dreamNode
	 */
    
    //TODO Consolidate Wall.populateDreamModel and Dream.populateDreamModel
    
	public DreamModel populateDreamModel(Node dreamNode) {
		
		DreamModel dream = new DreamModel();
		
		if(dreamNode != null) {

			dream.setAchieverUserId((String)dreamNode.getProperty("userid"));
			dream.setName((String)dreamNode.getProperty("name"));
			dream.setId((String)dreamNode.getProperty("id"));
			dream.setCreationDate(dreamNode.getProperty("creationdate").toString());
			dream.setDesc((String)dreamNode.getProperty("desc"));
			dream.setCategoryId((String)dreamNode.getProperty("categoryid"));
			dream.setCategoryName((String)dreamNode.getProperty("categoryname",null));
dream.setAchievements((String)dreamNode.getProperty("achievements",null));
			//users enabling this dream
			List<String> enablerIds = new ArrayList<String>();
			for(Node enabler:dao.getEnablersForDream(dream.getId())) {
				enablerIds.add((String)enabler.getProperty("id"));
			}
			
			dream.setEnablerUserIds(enablerIds);
			String[] videoLinks = (String[])dreamNode.getProperty("videolinks",null);
			if(videoLinks != null) {
				dream.setVideoLinks(Arrays.asList(videoLinks));
			}
			
			//users following this dream
			List<String> followerIds = new ArrayList<String>();
			for(Node n:dao.getFollowersForDream((String)dreamNode.getProperty("id"))) {
				followerIds.add((String)n.getProperty("id"));
			}
			dream.setFollowerUserIds(followerIds);
			
			//comments
			List<CommentModel> comments = new ArrayList<CommentModel>();
			for(Relationship r:dao.getCommentsForDream((String)dreamNode.getProperty("id"))) {
				CommentModel comment = new CommentModel();
				comment.setId((String)r.getProperty("id"));
				comment.setComment((String)r.getProperty("comment"));
				comment.setCommenterUserId((String)r.getProperty("commenteruserid"));
				comment.setCreationDate((String)r.getProperty("creationdate"));
				try {
					comment.setParentCommentId((String)r.getProperty("parentcommentid"));
				}
				catch(NotFoundException nfe) {}
				comment.setIsValid((boolean)r.getProperty("isvalid"));
				comments.add(comment);
			}
			dream.setComments(comments);
			
			//likes
			List<LikeModel> likes = new ArrayList<LikeModel>();
			for(Relationship r:dao.getLikesForDream((String)dreamNode.getProperty("id"))) {
				LikeModel like = new LikeModel();
				like.setId((String)r.getProperty("id"));
				like.setLikerUserId((String)r.getProperty("likeruserid"));
				like.setCreationDate((String)r.getProperty("creationdate"));
				like.setIsValid((boolean)r.getProperty("isvalid"));
				likes.add(like);
			}
			dream.setLikes(likes);
			
			dream.setLikeCount(dao.getLikesCountForDream(dream.getId()));
			dream.setCommentCount(dao.getCommentsCountForDream(dream.getId()));
			
			String[] imageKeys = (String[])dreamNode.getProperty("imagekeys",null);
			if(imageKeys != null) {
				dream.setImageKeys(Arrays.asList(imageKeys));
			}
		}
		else {
			throw new WebApplicationException(Response.status(404).entity("Dream not found: " + dream.getId()).build());
		}
		
		return dream;
	}
    
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DreamModel> getAllDreamsForUser(@PathParam("userId") String userId) {
    	
    	List<Node> dreamList = (List<Node>) dao.getDreamsForAchiever(userId);
    	List<DreamModel> dreams = new ArrayList<DreamModel>();
		for(Node dreamNode:dreamList) {	 			
    		dreams.add(getDream((String)dreamNode.getProperty("id")));
    	}  	
    	return dreams;
    }
    @GET
    @Path("/search/{searchstring}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DreamModel> getDreamsForSearchString(@PathParam("searchstring") String searchString) {
    	
    	List<DreamModel> retVal = new ArrayList<>();

    	try {
    		List<Node> dreamNodes = dao.getDreamsBySearchString(searchString);
    		
    		for(Node dreamNode:dreamNodes) {
    			DreamModel dm = new DreamModel();
    			dm.setId((String)dreamNode.getProperty("id"));
    			dm.setName((String)dreamNode.getProperty("name"));
    			retVal.add(dm);
    		}
    	}
    	catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get dreams for search string: " + searchString).build());
    	}
    	
    	return retVal;
    }

    private void populateDreamNode(Node dreamNode, DreamModel dream) {
    	
		if(!StringUtils.isEmpty(dream.getCategoryId())) {
			dreamNode.setProperty("categoryid", dream.getCategoryId());	
		}
		if(!StringUtils.isEmpty(dream.getCategoryName())) {
		dreamNode.setProperty("categoryname", dream.getCategoryName());
		}
		
		if(!StringUtils.isEmpty(dream.getDesc())) {
			dreamNode.setProperty("desc", dream.getDesc());
		}
		if(dream.getVideoLinks() != null) {	
			String[] currentVideoLinks = (String[])dreamNode.getProperty("videolinks",null);
			
			if(currentVideoLinks != null) {
				if(currentVideoLinks.length + dream.getVideoLinks().size() > Limits.MAX_VIDEO_LINKS) {
					throw new IllegalArgumentException("Max video links exceeded");
				}
				dream.getVideoLinks().addAll(Arrays.asList(currentVideoLinks));
			}
			
			dreamNode.setProperty("videolinks", dream.getVideoLinks());
		}
		
		if(dream.getImageKeys() != null) {	
			String[] currentImageLinks = (String[])dreamNode.getProperty("imagelinks",null);
			
			if(currentImageLinks != null) {
				if(currentImageLinks.length + dream.getImageKeys().size() > Limits.MAX_NUM_IMAGES) {
					throw new IllegalArgumentException("Max number of Images exceeded");
				}
				dream.getImageKeys().addAll(Arrays.asList(currentImageLinks));
			}
			
			dreamNode.setProperty("imagekeys", dream.getImageKeys());
		}
if(!StringUtils.isEmpty(dream.getAchievements())) {
			dreamNode.setProperty("achievements", dream.getAchievements());
		}    }
    
    private void validateNewDreamModel(DreamModel dream) {
    	
		if(StringUtils.isEmpty(dream.getDesc())) {
			throw new IllegalArgumentException("Dream description is required");
		}
		
		if(StringUtils.isEmpty(dream.getName())) {
			throw new IllegalArgumentException("Dream name is required");
		}
		
		if(StringUtils.isEmpty(dream.getCategoryId())) {
			throw new IllegalArgumentException("Dream category Id is required");
		}
		else {
			Node categoryNode = dao.getCategoryById(dream.getCategoryId());
			
			if(categoryNode == null) {
				throw new IllegalArgumentException("Category not found");
			} else {
				dream.setCategoryName((String) categoryNode.getProperty("name"));
			}
		}
		
		if(!StringUtils.isEmpty(dream.getAchieverUserId())) {
			Node achieverNode = dao.getUser(dream.getAchieverUserId());
			
			if(achieverNode == null) {
				throw new IllegalArgumentException("Achiever not found");
			}
		}
		else {
			throw new IllegalArgumentException("Achiever Id is required");
		}
    }

    private void validateExistingDreamModel(DreamModel dream) {
    	
		Node dreamNode = dao.getDream(dream.getId());
		if(dreamNode == null) {
			throw new IllegalArgumentException("Dream Id not found:" + dream.getId());
		}

		if(dream.getComments() != null) {
			for(CommentModel comment:dream.getComments()) {
				if(comment.isValid()) {
					Node commenterNode = dao.getUser(comment.getCommenterUserId());
					if(commenterNode != null) {
						comment.setCommenterUserNode(commenterNode);
					}
					else {
						throw new IllegalArgumentException("Commenter user Id not found:" + comment.getCommenterUserId());
					}
				}
				else {	//remove comment
					for(Relationship r:dreamNode.getRelationships(NPRelationships.COMMENTED)) {
						if(((String)r.getProperty("id")).equals(comment.getId())) {
    						comment.setCommentRelationship(r);
						}
					}
					
					if(comment.getCommentRelationship() == null) {
						throw new IllegalArgumentException("Comment Id not found:" + comment.getId());
					}
				}
			}
		}

		if(dream.getLikers() != null) {
			for(LikeModel like:dream.getLikers()) {
				if(like.isValid()) {
					Node likerNode = dao.getUser(like.getLikerUserId());
					if(likerNode != null) {
						like.setLikerUserNode(likerNode);
					}
					else {
						throw new IllegalArgumentException("Liker user Id not found:" + like.getLikerUserId());
					}
				}
				else {	//undo like
					for(Relationship r:dreamNode.getRelationships(NPRelationships.LIKED)) {
						if(((String)r.getProperty("id")).equals(like.getId())) {
    						like.setLikeRelationship(r);
						}
					}
					
					if(like.getLikeRelationship() == null) {
						throw new IllegalArgumentException("Like Id not found:" + like.getId());
					}
				}
			}
		}
    }
}
