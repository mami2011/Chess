package com.kryptonite.constants;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

public final class NPRelationships {

	public static RelationshipType ENABLING = DynamicRelationshipType.withName("enabling");	
	public static RelationshipType FOLLOWING = DynamicRelationshipType.withName("following");	
	public static RelationshipType ENABLE_REQUESTED = DynamicRelationshipType.withName("enableRequested");	
	public static RelationshipType COMMENTED = DynamicRelationshipType.withName("commented");
	public static RelationshipType SUPERCATEGORY = DynamicRelationshipType.withName("superCategory");
	public static RelationshipType SUBCATEGORY = DynamicRelationshipType.withName("subCategory");
	public static RelationshipType LIKED = DynamicRelationshipType.withName("liked");	
	public static RelationshipType HAS_SCOPE = DynamicRelationshipType.withName("has_scope");

}
