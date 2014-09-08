package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class WallModel {
	
	private String userId;
	private String userSessionId;
	private List<DreamModel> userDreams;
	private List<DreamModel> recommendedUserDreams;
	private List<DreamModel> topDreams;
	private List<String> recommendedAchieverUserIds;
	private List<String> recommendedEnablerUserIds;
//	private List<String> recommendedDreamIds;
	

	public String getId() {
		return userId;
	}

	public void setId(String id) {
		this.userId = id;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public List<DreamModel> getUserDreams() {
		return userDreams;
	}

	public void setUserDreams(List<DreamModel> dreams) {
		this.userDreams = dreams;
	}

	public List<DreamModel> getRecommendedUserDreams() {
		return recommendedUserDreams;
	}

	public void setRecommendedUserDreams(List<DreamModel> recommendedUserDreams) {
		this.recommendedUserDreams = recommendedUserDreams;
	}

	public List<DreamModel> getTopDreams() {
		return topDreams;
	}

	public void setTopDreams(List<DreamModel> topDreams) {
		this.topDreams = topDreams;
	}

	public List<String> getRecommendedAchieverUserIds() {
		return recommendedAchieverUserIds;
	}

	public void setRecommendedAchieverUserIds(
			List<String> recommendedAchieverUserIds) {
		this.recommendedAchieverUserIds = recommendedAchieverUserIds;
	}

	public List<String> getRecommendedEnablerUserIds() {
		return recommendedEnablerUserIds;
	}

	public void setRecommendedEnablerUserIds(
			List<String> recommendedEnablerUserIds) {
		this.recommendedEnablerUserIds = recommendedEnablerUserIds;
	}

/*	public List<String> getRecommendedDreamIds() {
		return recommendedDreamIds;
	}

	public void setRecommendedDreamIds(List<String> recommendedDreamIds) {
		this.recommendedDreamIds = recommendedDreamIds;
	}*/
	
}
