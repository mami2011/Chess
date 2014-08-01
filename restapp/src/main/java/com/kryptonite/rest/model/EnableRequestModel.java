package com.kryptonite.rest.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class EnableRequestModel implements Notifiable {

	private String id;	//request id
	private String dreamId;	//dream requesting to enable
	private String senderUserId;	//user sending the enable request
	private String receiverUserId;	//user receiving the enable request
	private String dateCreated;	//request creation date
	private String dateLastUpdated;	//accept/deny date
	private Boolean isAccepted;
	private Boolean isDenied;
	@JsonIgnore
	private Node userNode;
	@JsonIgnore
	private Node dreamNode;
	@JsonIgnore
	private Boolean isSentFromAchiever;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Boolean isDenied() {
		return isDenied;
	}
	public void setDenied(Boolean isDenied) {
		this.isDenied = isDenied;
	}
	public Node getUserNode() {
		return userNode;
	}
	public void setUserNode(Node userNode) {
		this.userNode = userNode;
	}
	public Node getDreamNode() {
		return dreamNode;
	}
	public void setDreamNode(Node dreamNode) {
		this.dreamNode = dreamNode;
	}
	public String getDateLastUpdated() {
		return dateLastUpdated;
	}
	public void setDateLastUpdated(String dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}
	public String getDreamId() {
		return dreamId;
	}
	public void setDreamId(String dreamId) {
		this.dreamId = dreamId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getSenderUserId() {
		return senderUserId;
	}
	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}
	public String getReceiverUserId() {
		return receiverUserId;
	}
	public void setReceiverUserId(String recieverUserId) {
		this.receiverUserId = recieverUserId;
	}
	public Boolean isSentFromAchiever() {
		return isSentFromAchiever;
	}
	public void setSentFromAchiever(boolean isSentFromAchiever) {
		this.isSentFromAchiever = isSentFromAchiever;
	}
}
