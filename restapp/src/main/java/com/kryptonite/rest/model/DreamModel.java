package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class DreamModel {

	private String id;
	private String name;
	private String achieverUserId;
	private List<String> enablerUserIds;
	private String desc;
	private String creationDate;
	private List<CommentModel> comments;
	private List<LikeModel> likes;
	private List<String> videoLinks;
	private List<String> followerUserIds;
	private String categoryId;
	private int likeCount;
	
	@JsonIgnore
	private List<Node> enablerUserNodes;

	public String getAchieverUserId() {
		return achieverUserId;
	}

	public void setAchieverUserId(String achieverId) {
		this.achieverUserId = achieverId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public List<CommentModel> getComments() {
		return comments;
	}

	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}

	public List<LikeModel> getLikers() {
		return likes;
	}

	public void setLikes(List<LikeModel> likes) {
		this.likes = likes;
	}

	public List<String> getVideoLinks() {
		return videoLinks;
	}

	public void setVideoLinks(List<String> videoLink) {
		this.videoLinks = videoLink;
	}
	public List<String> getEnablerUserIds() {
		return enablerUserIds;
	}

	public void setEnablerUserIds(List<String> enablerId) {
		this.enablerUserIds = enablerId;
	}

	public List<String> getFollowerUserIds() {
		return followerUserIds;
	}

	public void setFollowerUserIds(List<String> followers) {
		this.followerUserIds = followers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getEnablerUserNodes() {
		return enablerUserNodes;
	}

	public void setEnablerUserNodes(List<Node> enablingUserNodes) {
		this.enablerUserNodes = enablingUserNodes;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	
	
	
}
