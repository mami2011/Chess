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
import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.State;

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
		query.append("match (u { id:'").append(id.toLowerCase()).append("' }) return u");
		return(getNode(query.toString(),"u"));
	}
	
	public Relationship getEnableRequest(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enable request Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a)<-[r:enableRequested { id:'").append(id.toLowerCase()).append("' }]-(e) return r");
		return(getRelationship(query.toString(),"r"));
	}
	
	public Map<String,Relationship> getEnableRequestsSentForThisUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { userid:'").append(userId.toLowerCase()).append("' })-[er:enableRequested]->(u:user) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}

	public Map<String,Relationship> getEnableRequestsSentForOtherUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (u:user { id:'").append(userId.toLowerCase()).append("' })-[er:enableRequested]->(d:dream) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Map<String,Relationship> getEnableRequestsReceivedForThisUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { userid:'").append(userId.toLowerCase()).append("' })<-[er:enableRequested]-(u) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Map<String,Relationship> getEnableRequestsReceivedForOtherUserDreams(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream)-[er:enableRequested]->(u:user { id:'").append(userId.toLowerCase()).append("' }) return d.id ,er");
		return(getRelationshipMap(query.toString(),"d.id","er"));
	}
	
	public Node getAchiever(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Achiever Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public Node getDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}

	public Relationship getCommentById(String id, String userId) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Comment Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:commented {id:'").append(id.toLowerCase()).append("'}]->(b:dream { userid:'" + userId.toLowerCase() + "'}) return r");
		return(getRelationship(query.toString(),"r"));
	}

	public Relationship getLikeById(String id, String userId) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Like Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:liked {id:'").append(id.toLowerCase()).append("'}]->(b:dream { userid:'" + userId.toLowerCase() + "'}) return r");
		return(getRelationship(query.toString(),"r"));
	}
	

	public List<Relationship> getCommentsForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id.toLowerCase()).append("' })<-[r:commented]-(b:user) return r");
		return(getRelationships(query.toString(),"r"));
	}

	public List<Relationship> getLikesForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { id:'").append(id.toLowerCase()).append("' })<-[r:liked]-(b:user) return r");
		return(getRelationships(query.toString(),"r"));
	}

	public List<Node> getEnablersForAchiever(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Achiever Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever { id:'").append(id.toLowerCase()).append("' })<-[:enabling]-(b:enabler) return b");
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
		query.append("match (a:dream)<-[:enabling]-(b:enabler { id:'").append(enablerId.toLowerCase()).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}
	
	public List<Node> getAccomplishmentsForUser(String enablerId) {
		
		if(StringUtils.isEmpty(enablerId)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:dream { listedUserId:'").append(enablerId.toLowerCase()).append("' }) where a.currentState = "+State.LISTED+" return a");
		return(getNodes(query.toString(),"a"));
	}

	public List<Node> getEnablersForDream(String dreamId) {
		
		if(StringUtils.isEmpty(dreamId)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:enabler)-[:enabling]->(b { id:'").append(dreamId.toLowerCase()).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}

	public List<Node> getFollowersForDream(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Dream Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (d:dream { id:'").append(id.toLowerCase()).append("' })<-[:following]-(b) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public List<Node> getAchieversForEnabler(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:achiever)<-[:enabling]-(b:enabler { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNodes(query.toString(),"a"));
	}
	
	public List<Node> getFollowers(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user { id:'").append(id.toLowerCase()).append("' })<-[:following]-(b:user) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public List<Node> getFollowingUsers(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user { id:'").append(id.toLowerCase()).append("' })-[:following]->(b:user) return b");
		return(getNodes(query.toString(),"b"));
	}
	
	public Relationship getFollowerById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:user)-[r:following {id:'").append(id.toLowerCase()).append("'}]->(b) return r");
		return(getRelationship(query.toString(),"r"));
	}
	
	public List<Node> getFollowingDreams(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a { id:'").append(id.toLowerCase()).append("' })-[:following]->(b:dream) return b");
		return(getNodes(query.toString(),"b"));
	}

	public Node getEnabler(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Enabler Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (e:enabler { id:'").append(id.toLowerCase()).append("' }) return e");
		return(getNode(query.toString(),"e"));
	}
		
	public void addLabel(String id, String label) {
		//https://github.com/neo4j/java-rest-binding/issues/62 - use cypher query to add labels	
		StringBuilder query = new StringBuilder();
		query.append("match (n { id:'").append(id).append("' }) set n:" + label);
		engine.query(query.toString(), null);
	}
	
	public void removeLabel(String id, String label) {
		//https://github.com/neo4j/java-rest-binding/issues/62 - use cypher query to add labels	
		StringBuilder query = new StringBuilder();
		query.append("match (n { id:'").append(id).append("' }) remove n:" + label);
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
	
	private List<Integer> getIntResults(String query, String columnName) {

		List<Integer> results = new ArrayList<Integer> ();
		
			QueryResult<Map<String,Object>> result = engine.query(query, null);
		    
			for(Map<String, Object> row :result) {
				results.add((Integer) row.get(columnName));
			}
		
	    return results;
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
		query.append("match (a:category { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public Node getNotificationById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Notification Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:notification { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}
	
	public List<Node> getNewNotificationsForUser(String userId) {
		
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:notification { userid:'").append(userId.toLowerCase()).append("', acked:false}) return a");
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
	 * Dreams with recent Likes by User
	 * User's Dreams with recent comments
	 * User's Dreams with recent Likes
	 */
	
	
	// TODO Add Follow Logic
	
	public List<Node> getUserDreamsWithRecentCommentsOrLikes(String userId, long cursor)
	{
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id is not valid");
		}
		
		StringBuilder query = new StringBuilder();
		
		query.append("MATCH (u:user)-[r:commented|:liked|:enabling]->(n:dream  {userid:'")
		.append(userId.toLowerCase())
		.append("'}) with n, r ORDER BY r.creationdate DESC RETURN distinct n SKIP "+cursor+" LIMIT "+Limits.MAX_DREAMS_WALL_RESULTS)
		.append(" UNION MATCH (u:user {id:'")
		.append(userId.toLowerCase())
		.append("'})-[r:commented|:liked|:enabling]->(n:dream) with n, r ORDER BY r.creationdate DESC RETURN distinct n SKIP "+cursor+" LIMIT "+Limits.MAX_DREAMS_WALL_RESULTS)
		.append(" UNION MATCH (n:dream {userid:'")
		.append(userId.toLowerCase())
		.append("'}) WITH n ORDER BY n.creationdate DESC RETURN DISTINCT n SKIP "+cursor+" LIMIT "+Limits.MAX_DREAMS_WALL_RESULTS);
		/*.append(" UNION ")
		.append("MATCH (u:user)-[r:liked]->(n:dream  {userid:'")
		.append(userId)
		.append("'}) WHERE has(r.id) with n, r ORDER BY r.creationdate DESC LIMIT "+Limits.MAX_DREAMS_WALL_RESULTS+" RETURN distinct n");*/
		
		return getNodes(query.toString(),"n");
	}
	
	
	/**
	 * Tops Dreams in User's Categories
	 * 
	 * @param userId
	 * @return
	 */
	
	//TODO Sort Dreams in descending order by the count of Likes and Comments
	
	public List<Node> getTopDreamsInUserCategories(String userId, long cursor)
	{
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id is not valid");
		}
		
		StringBuilder query = new StringBuilder();
		
		query.append("match (c:category) with c match (d:dream {userid:'"+userId.toLowerCase()+"', categoryid: c.id}) <- [r:commented|:liked]- (:user) with d,r return d, count(r.id) as finalc order by finalc desc skip "+cursor);
				/*+ "union "
				+ "match (c:category) with c match (d:dream {userid:'"+userId+"', categoryid: c.id}) <- [r:liked]- (:user) with d,r return d, count(r.id) as finalc order by finalc desc"
				);*/

		return getNodes(query.toString(),"d");

	}
	
	
	/**
	 * Tops Dreams in any Categories
	 * 
	 * @param userId
	 * @return
	 */
	
	//TODO Sort Dreams in descending order by the count of Likes and Comments
	
	public List<Node> getTopDreamsInAllCategories(long cursor)
	{
		StringBuilder query = new StringBuilder();
		
		query.append("match (c:category) with c match (d:dream {categoryid: c.id}) <- [r:commented]- (:user) with d,r return d, count(r.id) as finalc order by finalc desc skip "+ cursor);
				/*+ "union "
				+ "match (c:category) with c match (d:dream {categoryid: c.id}) <- [r:liked]- (:user) with d,r return d, count(r.id) as finalc "
				);*/

		return getNodes(query.toString(),"d");
	}
	
	/**
	 * Users you might want to follow
	 * 
	 * Query:
	 * 
	 * MATCH (a:user{id:'harsh'})-[:`following`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5 
	 * 	UNION ALL 
	 * MATCH (a:user{id:'harsh'})-[:`enabling`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5 
	 * 	UNION ALL 
	 * MATCH (a:user{id:'harsh'})-[:`commented`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5
	 * 
	 * @param searchString
	 * @return
	 */
	
	//TODO Add logic to return some default Users if no activity
	public List<Node> getUsersYouMayLike(String userId)
	{
		if(StringUtils.isEmpty(userId)) {
			throw new IllegalArgumentException("User Id is not valid");
		}
		
		StringBuilder query = new StringBuilder();
		
		query.append("MATCH (a:user {id:'")
		.append(userId.toLowerCase())
		.append("'})-[:`following`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5")
		.append(" UNION ")
		.append("MATCH (a:user {id:'")
		.append(userId.toLowerCase())
		.append("'})-[:`enabling`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5")
		.append(" UNION ")
		.append("MATCH (a:user {id:'")
		.append(userId.toLowerCase())
		.append("'})-[:`commented`]->(b:dream) with a,b MATCH (c:user {id: b.userid}) WHERE NOT (a)-->(c) RETURN c LIMIT 5");
						
		return getNodes(query.toString(),"c");
	}
	
	public List<Node> getCategoriesBySearchString(String searchString) {
		
		if(StringUtils.isEmpty(searchString)) {
			throw new IllegalArgumentException("Search string cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:category) where a.name =~ '.*")
			.append(searchString.toLowerCase())
			.append(".*' return a as cat limit " 
			+ Limits.MAX_CATEGORIES_SEARCH_RESULTS)
			.append(" union match (a:category) where a.name =~ '.*")
			.append(searchString.toLowerCase())
			.append(".*' with a match (a:category)-[:subCategory]->(b:category) return b as cat limit " 
			+ Limits.MAX_CATEGORIES_SEARCH_RESULTS);
		
		retNodes.addAll(getNodes(query.toString(),"cat"));
		
		if(retNodes.size() < Limits.MAX_CATEGORIES_SEARCH_RESULTS) {
			query = new StringBuilder();
			query.append("match (a:category) where any ( t in a.tags where t =~ '.*")
				.append(searchString.toLowerCase())
				.append(".*') return a as cat limit " 
				+ (Limits.MAX_CATEGORIES_SEARCH_RESULTS - retNodes.size()))
				.append(" union match (a:category) where any ( t in a.tags where t =~ '.*")
				.append(searchString.toLowerCase())
				.append(".*') with a match (a:category)-[:subCategory]->(b:category) return b as cat limit " 
				+ Limits.MAX_CATEGORIES_SEARCH_RESULTS);
			retNodes.addAll(getNodes(query.toString(),"cat"));
		}
		
		return retNodes;
	}
	
public List<Node> getEnablersBySearchString(String searchString) {
		
		if(StringUtils.isEmpty(searchString)) {
			throw new IllegalArgumentException("Search string cannot be empty");
		}
		
		List<Node> retNodes = new ArrayList<>();
				
		if(retNodes.size() < Limits.MAX_USERS_SEARCH_RESULTS) {
			StringBuilder query = new StringBuilder();
			query.append("match (u:user) where ( u.firstname=~ '(?i)")
			.append(searchString)
			.append(".*' OR")
			.append("  u.lastname=~ '(?i)")
			.append(searchString)
			.append(".*'  OR u.id=~ '(?i)")
			.append(searchString)
			.append(".*') AND u.accounttype ='ENABLER' return u limit ")
			.append(Limits.MAX_USERS_SEARCH_RESULTS );
			retNodes.addAll(getNodes(query.toString(),"u"));
		}
		
		return retNodes;
	}
	
public List<Node> getAchieversBySearchString(String searchString) {
	
	if(StringUtils.isEmpty(searchString)) {
		throw new IllegalArgumentException("Search string cannot be empty");
	}
	
	List<Node> retNodes = new ArrayList<>();
			
	if(retNodes.size() < Limits.MAX_USERS_SEARCH_RESULTS) {
		StringBuilder query = new StringBuilder();
		query.append("match (u:user) where ( u.firstname=~ '(?i)")
		.append(searchString)
		.append(".*' OR")
		.append("  u.lastname=~ '(?i)")
		.append(searchString)
		.append(".*'  OR u.id=~ '(?i)")
		.append(searchString)
		.append(".*') AND (u.accounttype ='ACHIEVER' OR u.accounttype ='ACHIVER') return u limit ")
		.append(Limits.MAX_USERS_SEARCH_RESULTS );
		retNodes.addAll(getNodes(query.toString(),"u"));
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
			
			StringBuilder subQuery = new StringBuilder();
			subQuery.append("match (d:dream)<-[r:liked]-(u:user) where d.categoryid='")
				.append(thisCatId.toLowerCase())
				.append("' return d,count(r) as numlikes order by numlikes limit ")
				.append(Limits.MAX_DREAMS_SEARCH_RESULTS);
			
			retNodes.addAll(getNodes(subQuery.toString(),"d"));
			
			if(retNodes.size() < Limits.MAX_DREAMS_SEARCH_RESULTS) {
				subQuery = new StringBuilder();
				subQuery.append("match (d:dream) where d.categoryid='")
					.append(thisCatId.toLowerCase())
					.append("' return d limit ")
					.append(Limits.MAX_DREAMS_SEARCH_RESULTS - retNodes.size());

				retNodes.addAll(getNodes(subQuery.toString(),"d"));
			}
		}
		
		//search dream  title  case insensitive 
		
		StringBuilder query = new StringBuilder();
				query.append("match (d:dream) where d.name=~ '(?i).*")
					.append(searchString)
					.append(".*' OR  d.desc=~ '(?i).*")
					.append(searchString)
					.append(".*' return d limit ")
					.append(Limits.MAX_DREAMS_SEARCH_RESULTS - retNodes.size());
				
				retNodes.addAll(getNodes(query.toString(),"d"));
		
		return retNodes;
	}	
	
public Node getMessageById(String id) {
		
		if(StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Message Id cannot be empty");
		}
		
		StringBuilder query = new StringBuilder();
		query.append("match (a:message { id:'").append(id.toLowerCase()).append("' }) return a");
		return(getNode(query.toString(),"a"));
	}

public int getUnreadMessageCountByUserId(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("User Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:message { userid:'")
	.append(id.toLowerCase())
	.append("', isread:false}) return count(a) as b");
	
	List<Integer> result = getIntResults(query.toString(),"b");
	
	int count = result.get(0);
	
	return count;
}

public List<Node> getMessagesByUserId(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("User Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:message { userid:'")
	.append(id.toLowerCase())
	.append("'}) return a ORDER BY a.creationdate desc");
	
	List<Node> nodeList = getNodes(query.toString(),"a");
	

	return nodeList;
}



public int getLikesCountForDream(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("Dream Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:dream { id:'").append(id.toLowerCase()).append("' })<-[r:liked]-(b:user) return r");
	List<Node> nodeList = getNodes(query.toString(),"a");
	int count = nodeList.size();
	return count;
}

public int getCommentsCountForDream(String id) {
	
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("Dream Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("match (a:dream { id:'").append(id.toLowerCase()).append("' })<-[r:commented]-(b:user) return r");
	List<Node> nodeList = getNodes(query.toString(),"a");
	int count = nodeList.size();
	return count;
}

/**
 * Get Recommended DreamIds for an Enabler
 * 
 * Algorithm:
 * 
 * 1) Get All Dreams enabled by this Enabler - E1.
 * 2) Get Categories of these dreams C1
 * 3) Get all Dreams in C1 and Sub Categories of C1
 * 4) Recommend Dreams from 3) and not enabled by E1 or any one
 * 
 * TODO: An enhancement would be to Recommend Dreams not enabled by anyone first and then rest
 */

public List<Node> getRecommendedDreamsForEnabler(String enablerId)
{
	if(StringUtils.isEmpty(enablerId)) {
		throw new IllegalArgumentException("Enabler Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();
	query.append("MATCH (d1: dream) - [:enabling] - (a:enabler {id:'"+enablerId.toLowerCase()+"'}) ")
		.append("MATCH (c:category {id:d1.categoryid})-[:superCategory*0..]-(ca:category) ")
		.append("MATCH (d2:dream {categoryid: ca.id}) WHERE NOT (d2 - [:enabling]-(:enabler {id:'"+enablerId.toLowerCase()+"'})) return distinct d2");
	
	List<Node> nodeList = getNodes(query.toString(),"d2");
	
	return nodeList;
}


public List<Node> getConnectedEnablersOrAchievers(String userId, String type)
{
	if(StringUtils.isEmpty(userId)) {
		throw new IllegalArgumentException("Enabler Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();

	if(type.equalsIgnoreCase(NPLabels.ENABLER.toString()))
		query.append("MATCH (n:`enabler` {id:'"+userId+"'} )-[:enabling]->(d:dream) MATCH (u:user {id: d.userid}) RETURN u");		
	else		
		query.append("MATCH (u:`enabler`)-[:enabling]->(d:dream { userid:'"+userId+"'}) MATCH (n:user {id: d.userid}) RETURN u");	

	
	List<Node> nodeList = getNodes(query.toString(),"u");
	
	return nodeList;
}


public List<Node> getEnablerScopesForCategory(String categoryId)
{
	if(StringUtils.isEmpty(categoryId)) {
		throw new IllegalArgumentException("Category Id cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();

	query.append("match (a:category {id:'")
	.append(categoryId)
	.append("'})-[:hasEnableScope]->(b:scope) return b");		
	
	return getNodes(query.toString(),"b");
}

public Node getEnablerScopes(String id)
{
	if(StringUtils.isEmpty(id)) {
		throw new IllegalArgumentException("Id cannot be empty");
	}

	StringBuilder query = new StringBuilder();

	query.append("match (a:scope {id:'").append(id)
	.append("'}) return a");		
	
	return getNode(query.toString(),"a");
}

public List<Node> getEnablerScopes(String name, String achieverScopeText, String enablerScopeText)
{
	if(StringUtils.isEmpty(name)) {
		throw new IllegalArgumentException("Name cannot be empty");
	}
	
	if(StringUtils.isEmpty(name)) {
		throw new IllegalArgumentException("Achiever Scope cannot be empty");
	}
	
	if(StringUtils.isEmpty(name)) {
		throw new IllegalArgumentException("Enabler Scope cannot be empty");
	}
	
	StringBuilder query = new StringBuilder();

	query.append("match (a:scope {name:'").append(name)
	.append("',achieverScopeText:'").append(achieverScopeText)
	.append("',enablerScopeText:'").append(enablerScopeText).append("'}) return a");		
	
	return getNodes(query.toString(),"a");
}

}