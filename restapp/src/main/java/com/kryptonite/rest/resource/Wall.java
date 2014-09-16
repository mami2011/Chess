/**
 * Core Concept of Wall displaying all the dynamic details when a NutPeddler Logs in
 * 
 * Wall Consists of:
 * 
 * Top Global Updates:
 * 					Top Global Updates will have
 * 					Achievement Updates
 * 					Dream Updates
 * 					Most Followed Dreams
 * 
 * Recommendations:
 * 					Similar Dreams 
 * 					Similar Achievers
 * 					Similar Enablers
 * 					Likes
 * 					Comments
 * 
 * Top User Tailored Updates:
 * 					Dream Updates
 * 						Owned(Created/Followed/Enabled) Dream's Activity
 * 					Enabler Updates
 * 					Achievers Updates
 * 					Likes
 * 					Comments
 * 
 * 
 * Algorithm:
 * 
 */
package com.kryptonite.rest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Relationship;

import com.kryptonite.rest.model.CommentModel;
import com.kryptonite.rest.model.DreamModel;
import com.kryptonite.rest.model.LikeModel;
//import com.kryptonite.rest.model.DreamModel;
import com.kryptonite.rest.model.UserModel;
import com.kryptonite.rest.model.WallModel;
import com.kryptonite.utils.DAO;
/**
 * @author harsh
 *
 */
@PermitAll
@Path("users/{id}/wall/cursor/{cid}")
public class Wall {

@Inject
Dream dream;

@Inject 
DAO dao;
	
	@PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WallModel getWall(@PathParam("id") @Pattern(regexp = "[A-Z]*[a-z]+[.]?[-]*[0-9]*", 
    						message = "The user id must be a valid i.e. a combination of uppercase/lower case alphabets, numbers, \".\" and \"-\" characters") String userId,
    						@PathParam("cid") @DefaultValue("0") long cursor) {
    	
		Map<String,DreamModel> currentDream = new LinkedHashMap<String,DreamModel> ();
   

		//TODO Optimize to not fire query 
		WallModel wallData = new WallModel();
		
		wallData.setId(userId);
		
		// 1. Get 5 Enabled/Achieved dreams with most recent comments
	    	List<Node> dreamList = (List<Node>) dao.getUserDreamsWithRecentCommentsOrLikes(userId, cursor);
	   	
	    	List<DreamModel> dreams = updateDreamModel(dreamList, currentDream);    	
    	
    	wallData.setUserDreams(dreams);
    	    	
    	// 2. Get Top Trafficked Dreams in User Categories
    	
    		List<Node> topUserCategoryDreamList = (List<Node>) dao.getTopDreamsInUserCategories(userId, cursor);
    		
    		dreams = updateDreamModel(topUserCategoryDreamList,currentDream);   		
    		
    		wallData.setRecommendedUserDreams(dreams);
    		
    	// 3. Get Top Trafficked Dreams in All Categories
    	
    		List<Node> topCategoryDreamList = (List<Node>) dao.getTopDreamsInAllCategories(cursor);
    		
    		dreams = updateDreamModel(topCategoryDreamList,currentDream);   	
    		
    		wallData.setTopDreams(dreams);
    		
    	// 4. Get dreams you may want to enable
    		List<Node> recommendedDreamsForEnabler = dao.getRecommendedDreamsForEnabler(userId);
    		List<DreamModel> recommendedDreamsForEnablerList = new ArrayList<DreamModel>();
    		
    		for(int i = 0; i<recommendedDreamsForEnabler.size(); i++)
        	{
        		Node dreamNode = (Node) recommendedDreamsForEnabler.get(i);
        		DreamModel dreamModel = updateDreamModel(dreamNode);
        		recommendedDreamsForEnablerList.add(dreamModel);
        	}
    		
    		wallData.setRecommendedUserDreams(recommendedDreamsForEnablerList);

    	// 5. Get Enablers you may Like 
    		
    	//TODO Get ONLY USER IDs instead of Whole UserObjects
    	
    	List<Node> userList = (List<Node>) dao.getUsersYouMayLike(userId);
    	
    	List<String> userIds = new ArrayList<String>();
    	
    	for(int i=0 ; i<userList.size() ; i++)
    	{
    		Node userNode = userList.get(i);
    		if(userNode != null)
    			userIds.add((String)userNode.getProperty("id"));
    	}
    	
    	//wallData.setRecommendedAchieverUserIds(userIds);
    	
    	//TODO Implement query to load Recommended Enabler Ids
    	
    	wallData.setRecommendedEnablerUserIds(userIds);
    	
    	return wallData;
    }
	
	
    
    @PermitAll    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel getUserDreamActivity(@PathParam("id") String id) {
    	
    return null;
    }
    
    
    private List<DreamModel> updateDreamModel(List<Node> dreamList, Map<String, DreamModel> dreams)

    {
    	List<DreamModel> currentDreams = new ArrayList<DreamModel>();
    	
    	//TODO Clean up the dream model
    	for(int i = 0; i<dreamList.size(); i++)
    	{
    		Node dreamNode = (Node) dreamList.get(i);
    		DreamModel dreamModel = updateDreamModel(dreamNode);
    		if(dreams.containsKey(dreamModel.getId()) == false) //doesn't contain the dream in question already
    		{
    			currentDreams.add(dreamModel);
    		}
    	}
    	
    	return currentDreams;
    }
    
    private DreamModel updateDreamModel(Node dreamNode)
    {

    		DreamModel dreamModel = new DreamModel();
	    	
	   /* 	dreamModel.setAchieverUserId((String)dreamNode.getProperty("userid"));
			dreamModel.setName((String)dreamNode.getProperty("name"));
			dreamModel.setId((String)dreamNode.getProperty("id"));
			dreamModel.setCreationDate(dreamNode.getProperty("creationdate").toString());
			dreamModel.setDesc((String)dreamNode.getProperty("desc"));
				List<CommentModel> comments = new ArrayList<CommentModel>(); 		
	
				Iterable<Relationship> rels = (Iterable<Relationship>) dreamNode.getRelationships(NPRelationships.COMMENTED);
				  			
			for(Relationship rel:rels) {
					CommentModel comment = new CommentModel();
					comment.setId((String)rel.getProperty("id"));
					comment.setComment((String)rel.getProperty("comment"));
					comment.setCommenterUserId((String)rel.getProperty("commenteruserid"));
					comment.setCreationDate((String)rel.getProperty("creationdate"));
					try {
						comment.setParentCommentId((String)rel.getProperty("parentcommentid"));
					}
					catch(NotFoundException nfe) {}
					comment.setIsValid((boolean)rel.getProperty("isvalid"));
					comments.add(comment);
				}
				dreamModel.setComments(comments);*/
    	    		
    		dreamModel = populateDreamModel(dreamNode);
		
			return dreamModel;
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
				
				if(!dream.isLikedByCurrentUser())
					if(((String) (r.getProperty("likeruserid"))).equals(dream.getAchieverUserId()))
						dream.setLikedByCurrentUser(true);
				
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
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
