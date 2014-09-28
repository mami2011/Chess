package com.kryptonite.rest.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class LikeModel implements Notifiable {

	private String id;
	private String creationDate;
	private String likerUserId;
	private boolean isValid = true;
	@JsonIgnore
	private Node likerUserNode;
	@JsonIgnore
	private Relationship likeRelationship;
	private String dreamId;

	
	public String getDreamId() {
		return dreamId;
	}
	public void setDreamId(String dreamId) {
		this.dreamId = dreamId;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLikerUserId() {
		return likerUserId;
	}
	public void setLikerUserId(String likerUserId) {
		this.likerUserId = likerUserId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Node getLikerUserNode() {
		return likerUserNode;
	}
	public void setLikerUserNode(Node likerUserNode) {
		this.likerUserNode = likerUserNode;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Relationship getLikeRelationship() {
		return likeRelationship;
	}
	public void setLikeRelationship(Relationship likeRelationship) {
		this.likeRelationship = likeRelationship;
	}
}
