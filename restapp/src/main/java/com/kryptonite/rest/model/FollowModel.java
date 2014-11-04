package com.kryptonite.rest.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class FollowModel implements Notifiable {

	private String id;
	private String followerUserId;
	private String creationDate;
	private String dreamId;
	private Boolean acked;
	
	public Boolean getAcked() {
		return acked;
	}
	public void setAcked(Boolean acked) {
		this.acked = acked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFollowerUserId() {
		return followerUserId;
	}
	public void setFollowerUserId(String followerUserId) {
		this.followerUserId = followerUserId;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getDreamId() {
		return dreamId;
	}
	public void setDreamId(String dreamId) {
		this.dreamId = dreamId;
	}
	
	
}
