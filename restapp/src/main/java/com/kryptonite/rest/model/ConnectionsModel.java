package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class ConnectionsModel {
	
	private List<UserModel> followers;
	private List<UserModel> following;
	private List<UserModel> enablers;
	private List<UserModel> achievers;
	
	public List<UserModel> getFollowers() {
		return followers;
	}
	public void setFollowers(List<UserModel> followers) {
		this.followers = followers;
	}
	public List<UserModel> getFollowing() {
		return following;
	}
	public void setFollowing(List<UserModel> following) {
		this.following = following;
	}
	public List<UserModel> getEnablers() {
		return enablers;
	}
	public void setEnablers(List<UserModel> enablers) {
		this.enablers = enablers;
	}
	public List<UserModel> getAchievers() {
		return achievers;
	}
	public void setAchievers(List<UserModel> achievers) {
		this.achievers = achievers;
	}
	
}
