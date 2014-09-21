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
	private List<String> imageKeys;
	private List<String> videoLinks;
	private List<String> followerUserIds;
	private String categoryId;
	private String categoryName;
	private int likeCount;
	private int commentCount;
	private int nextCursor;
	private String nextCursorString;
	private int previousCursor;
	private String previousCursorString;
	private boolean isLikedByCurrentUser = false;
	private String achievements;
	
	@JsonIgnore
	private List<Node> enablerUserNodes;
	
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAchieverUserId() {
		return achieverUserId;
	}

	public void setAchieverUserId(String achieverId) {
		this.achieverUserId = achieverId;
	}
	

	public List<String> getImageKeys() {
		return imageKeys;
	}

	public void setImageKeys(List<String> imageKeys) {
		this.imageKeys = imageKeys;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(int nextCursor) {
		this.nextCursor = nextCursor;
	}

	public String getNextCursorString() {
		return nextCursorString;
	}

	public void setNextCursorString(String nextCursorString) {
		this.nextCursorString = nextCursorString;
	}

	public int getPreviousCursor() {
		return previousCursor;
	}

	public void setPreviousCursor(int previousCursor) {
		this.previousCursor = previousCursor;
	}

	public String getPreviousCursorString() {
		return previousCursorString;
	}

	public void setPreviousCursorString(String previousCursorString) {
		this.previousCursorString = previousCursorString;
	}

	public List<LikeModel> getLikes() {
		return likes;
	}

	public boolean isLikedByCurrentUser() {
		return isLikedByCurrentUser;
	}

	public void setLikedByCurrentUser(boolean isLikeByCurrentUser) {
		this.isLikedByCurrentUser = isLikeByCurrentUser;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	
	
	
}
