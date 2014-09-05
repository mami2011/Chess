package com.kryptonite.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang.StringUtils;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;
import org.neo4j.rest.graphdb.util.QueryResult;

import com.kryptonite.constants.Limits;

@Singleton
public class DAO {
	
	@Inject
	private RestCypherQueryEngine engine;
	//private ExecutionEngine engine;
	
	public Node getUser(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (u { id:'").append(id).append("' }) return u");
		return(getNode(query.toString(),"u"));
	}
	
	public Relationship getEnableRequest(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enable request Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a)<-[r:enableRequested { id:'").append(id).append("' }]-(e) return r");
		return(getRelationship(query.toString(),"r"));
	}
	
	public Map<String,Relationship> getEnableRequestsSentForThisUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { userid:'").append(userId).append("' })-[er:enableRequested]->(u:user) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}

	public Map<String,Relationship> getEnableRequestsSentForOtherUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (u:user { id:'").append(userId).append("' })-[er:enableRequested]->(d:dream) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Map<String,Relationship> getEnableRequestsReceivedForThisUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { userid:'").append(userId).append("' })<-[er:enableRequested]-(u) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Map<String,Relationship> getEnableRequestsReceivedForOtherUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream)-[er:enableRequested]->(u:user { id:'").append(userId).append("' }) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Node getAchiever(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Achiever Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever { id:'").append(id).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public Node getDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}

	public Relationship getCommentById(String id, String userId) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Comment Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:commented {id:'").append(id).append("'}]->(b:dream { userid:'" + userId + "'}) return r");
		return(getRelationship(query.toString(),"r"));
	}

	public Relationship getLikeById(String id, String userId) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Like Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:liked {id:'").append(id).append("'}]->(b:dream { userid:'" + userId + "'}) return r");
		return(getRelationship(query.toString(),"r"));
	}
	
	public List<Relationship> getCommentsForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id).append("' })<-[r:commented]-(b:user) return r");
		return(getRelationships(query.toString(),"r"));
	}

	public List<Relationship> getLikesForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id).append("' })<-[r:liked]-(b:user) return r");
		return(getRelationships(query.toString(),"r"));
	}

	public List<Node> getEnablersForAchiever(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Achiever Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever { id:'").append(id).append("' })<-[:enabling]-(b) return b");
		return(getNodes(query.toString(),"b"));
	}

	public List<Node> getDreamsForAchiever(String achieverId) {
		
		if(StringUtils.isEmpty(achieverId)) {
			throw new IllegalArgumentException("Achiever Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { userid:'").append(achieverId).append("' }) return d");
		return(getNodes(query.toString(),"d"));
	}

	public List<Node> getDreamsForEnabler(String enablerId) {
		
		if(StringUtils.isEmpty(enablerId)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream)<-[:enabling]-(b { id:'").append(enablerId).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}

	public List<Node> getEnablersForDream(String dreamId) {
		
		if(StringUtils.isEmpty(dreamId)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:enabler)-[:enabling]->(b { id:'").append(dreamId).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}

	public List<Node> getFollowersForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { id:'").append(id).append("' })<-[:following]-(b) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public List<Node> getAchieversForEnabler(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever)<-[:enabling]-(b:enabler { id:'").append(id).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}
	
	public List<Node> getFollowers(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a { id:'").append(id).append("' })<-[:following]-(b:user) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public List<Node> getFollowingUsers(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a { id:'").append(id).append("' })-[:following]->(b:user) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public Relationship getFollowerById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:following {id:'").append(id).append("'}]->(b) return r");
		return(getRelationship(query.toString(),"r"));
	}
	
	public List<Node> getFollowingDreams(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a { id:'").append(id).append("' })-[:following]->(b:dream) return b");
		return(getNodes(query.toString(),"b"));
	}

	public Node getEnabler(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (e:enabler { id:'").append(id).append("' }) return e");
		return(getNode(query.toString(),"e"));
	}
		
	public void addLabel(String id, String label) {
		//https://github.com/neo4j/java-rest-binding/issues/62 - use cypher query to add labels	
		StringBuilder query = new StringBuilder();
		query.append("match (n { id:'").append(id).append("' }) set n:" + label);
		engine.query(query.toString(), null);
	}
	
	private Node getNode(String query, String columnName) {
		
		Node retNode = null;
		
		/*ExecutionResult result = engine.execute(query);
		
		Iterator<Node> column = result.columnAs( columnName );
		for ( Node node : IteratorUtil.asIterable( column ) )
		{
			retNode = node;
		}*/
		
		QueryResult<Map<String,Object>> result = null;
//		try ( Transaction tx1 = db.beginTx(); )
//    	{
			result = engine.query(query, null);
//			tx1.success();
//    	}
		
		
		for(Map<String, Object> row :result) {
			retNode = (Node)row.get(columnName);
			break;
		}
		
	    return retNode;
	}
	
	private List<Node> getNodes(String query, String columnName) {
		
		List<Node> retNodes = new ArrayList<Node>();
		
		/*ExecutionResult result = engine.execute(query);
		
		Iterator<Node> column = result.columnAs( columnName );
		for ( Node node : IteratorUtil.asIterable( column ) )
		{
			retNodes.add(node);
		}*/
		
//		try ( Transaction tx1 = db.beginTx(); ) 
//    	{
			QueryResult<Map<String,Object>> result = engine.query(query, null);
		    
			for(Map<String, Object> row :result) {
				retNodes.add((Node)row.get(columnName));
			}
//    	}
		
	    return retNodes;
	}
	
	
	private List<Relationship> getRelationships(String query, String columnName) {
		
		List<Relationship> retRels = new ArrayList<Relationship>();
		
		QueryResult<Map<String,Object>> result = engine.query(query, null);
	    
		for(Map<String, Object> row :result) {
			retRels.add((Relationship)row.get(columnName));
		}
		
	    return retRels;
	}
	
	
	private Map<String,Relationship> getRelationshipMap(String query, 
			String keyColumnName, String valueColumnName) {
		
		Map<String,Relationship> retRels = new HashMap<String,Relationship>();
		
		QueryResult<Map<String,Object>> result = engine.query(query, null);
	    
		for(Map<String, Object> row :result) {
			retRels.put((String)row.get(keyColumnName),(Relationship)row.get(valueColumnName));
		}
		
	    return retRels;
	}
	
	private Relationship getRelationship(String query, String columnName) {
		
		Relationship retRel = null;
		
		QueryResult<Map<String,Object>> result = engine.query(query, null);
	    
		for(Map<String, Object> row :result) {
			retRel = (Relationship)row.get(columnName);
			break;
		}
		
	    return retRel;
	}
	
	public Node getCategoryById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Category Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:category { id:'").append(id).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public Node getNotificationById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Notification Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:notification { id:'").append(id).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public List<Node> getNewNotificationsForUser(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:notification { userid:'").append(userId).append("', acked:false}) return a");
		retNodes.addAll(getNodes(query.toString(),"a"));
		
		return retNodes;
	}

	public Node getUserByAuthToken(String authToken) {
		
		if(StringUtils.isEmpty(authToken)) {
			throw new IllegalArgumentException("Authorization Token not valid");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (u { authToken:'").append(authToken).append("' }) return u");
		return(getNode(query.toString(),"u"));
	}
	
	/**
	 * Returns list of all nodes searched by relationship property:
	 * 
	 * Dreams with recent comments of User
	 * Dreams with recent Likes
	 */
	
	public List<Node> getUserDreamsWithRecentCommentsOrLikes(String userId)
	{
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id is not valid");
		}
		
		StringBuilder query = new StringBuilder();
		
		query.append("MATCH (u:user)-[r:commented]->(n:dream  {userid:'")
		.append(userId)
		.append("'}) WHERE has(r.`comment`) with n, r ORDER BY r.creationdate DESC LIMIT 5 RETURN distinct n")
		.append(" UNION ")
		.append("MATCH (u:user)-[r:liked]->(n:dream  {userid:'")
		.append(userId)
		.append("'}) WHERE has(r.id) with n, r ORDER BY r.creationdate DESC LIMIT 5 RETURN distinct n");
				
		return getNodes(query.toString(),"n");
	}
	
	
	/**
	 * Users you might want to follow
	 * 
	 * Query:
	 * 
	 * MATCH (a:user{id:'harsh'})-[:`following`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5 
	 * 	UNION ALL 
	 * MATCH (a:user{id:'harsh'})-[:`enabling`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5 
	 * 	UNION ALL 
	 * MATCH (a:user{id:'harsh'})-[:`commented`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5
	 * 
	 * @param searchString
	 * @return
	 */
	
	public List<Node> getUsersYouMayLike(String userId)
	{
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id is not valid");
		}
		
		StringBuilder query = new StringBuilder();
		
		query.append("MATCH (a:user {id:'")
		.append(userId)
		.append("'})-[:`following`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5")
		.append(" UNION ")
		.append("MATCH (a:user {id:'")
		.append(userId)
		.append("'})-[:`enabling`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5")
		.append(" UNION ")
		.append("MATCH (a:user {id:'")
		.append(userId)
		.append("'})-[:`commented`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) RETURN c LIMIT 5");
						
		return getNodes(query.toString(),"c");
	}
	
	public List<Node> getCategoriesBySearchString(String searchString) {
		
		if(StringUtils.isEmpty(searchString)) {
			throw new IllegalArgumentException("Search string cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:category) where a.name =~ '.*")
			.append(searchString)
			.append(".*' return a as cat limit " 
			+ Limits.MAX_CATEGORIES_SEARCH_RESULTS)
			.append(" union match (a:category) where a.name =~ '.*")
			.append(searchString)
			.append(".*' with a match (a:category)-[:subCategory]->(b:category) return b as cat limit " 
			+ Limits.MAX_CATEGORIES_SEARCH_RESULTS);
		
		retNodes.addAll(getNodes(query.toString(),"cat"));
		
		if(retNodes.size() < Limits.MAX_CATEGORIES_SEARCH_RESULTS) {
			query = new StringBuilder();
			query.append("match (a:category) where any ( t in a.tags where t =~ '.*")
				.append(searchString)
				.append(".*') return a as cat limit " 
				+ (Limits.MAX_CATEGORIES_SEARCH_RESULTS - retNodes.size()))
				.append(" union match (a:category) where any ( t in a.tags where t =~ '.*")
				.append(searchString)
				.append(".*') with a match (a:category)-[:subCategory]->(b:category) return b as cat limit " 
				+ Limits.MAX_CATEGORIES_SEARCH_RESULTS);
			retNodes.addAll(getNodes(query.toString(),"cat"));
		}
		
		return retNodes;
	}
	
	public List<Node> getDreamsBySearchString(String searchString) {
		
		if(StringUtils.isEmpty(searchString)) {
			throw new IllegalArgumentException("Search string cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
		
		List<Node> categoryNodes = getCategoriesBySearchString(searchString);
		
		for(Node categoryNode:categoryNodes) {
			
			String thisCatId = (String)categoryNode.getProperty("id");
			
			StringBuilder query = new StringBuilder();
			query.append("match (d:dream)<-[r:liked]-(u:user) where d.categoryid='")
				.append(thisCatId)
				.append("' return d,count(r) as numlikes order by numlikes limit ")
				.append(Limits.MAX_DREAMS_SEARCH_RESULTS);
			
			retNodes.addAll(getNodes(query.toString(),"d"));
			
			if(retNodes.size() < Limits.MAX_DREAMS_SEARCH_RESULTS) {
				query = new StringBuilder();
				query.append("match (d:dream) where d.categoryid='")
					.append(thisCatId)
					.append("' return d limit ")
					.append(Limits.MAX_DREAMS_SEARCH_RESULTS - retNodes.size());

				retNodes.addAll(getNodes(query.toString(),"d"));
			}
		}
		
		return retNodes;
	}	
	
public Node getMessageById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Message Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:message { id:'").append(id).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}

public int getUnreadMessageCountByUserId(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("User Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:message { userid:'")
	.append(id)
	.append("', isread:false}) return a");
	
	List<Node> nodeList = getNodes(query.toString(),"a");
	
	int count = nodeList.size();
	
	return count;
}

public List<Node> getMessagesByUserId(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("User Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:message { userid:'")
	.append(id)
	.append("'}) return a ORDER BY a.creationdate desc");
	
	List<Node> nodeList = getNodes(query.toString(),"a");
	

	return nodeList;
}



public int getLikesCountForDream(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("Dream Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:dream { id:'").append(id).append("' })<-[r:liked]-(b:user) return r");
	List<Node> nodeList = getNodes(query.toString(),"a");
	int count = nodeList.size();
	return count;
}

public int getCommentsCountForDream(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("Dream Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:dream { id:'").append(id).append("' })<-[r:commented]-(b:user) return r");
	List<Node> nodeList = getNodes(query.toString(),"a");
	int count = nodeList.size();
	return count;
}


}
