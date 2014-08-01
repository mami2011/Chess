package com.kryptonite.rest.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class CommentModel implements Notifiable {

	private String id;
	private String parentCommentId;
	private String comment;
	private String creationDate;
	private String commenterUserId;
	private boolean isValid = true;
	@JsonIgnore
	private Node commenterUserNode;
	@JsonIgnore
	private Relationship commentRelationship;

	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCommenterUserId() {
		return commenterUserId;
	}
	public void setCommenterUserId(String commenterUserId) {
		this.commenterUserId = commenterUserId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public Node getCommenterUserNode() {
		return commenterUserNode;
	}
	public void setCommenterUserNode(Node commenterUserNode) {
		this.commenterUserNode = commenterUserNode;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Relationship getCommentRelationship() {
		return commentRelationship;
	}
	public void setCommentRelationship(Relationship commentRelationship) {
		this.commentRelationship = commentRelationship;
	}
}
