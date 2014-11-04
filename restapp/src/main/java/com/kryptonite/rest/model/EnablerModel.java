package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class EnablerModel {
	
	private String enablerDescription;
	private String enablerTermsOfAgreement;
	private List<String> enablerAchievements;
	private List<String> enablerImageKeys;
	private List<String> enablerVideoLinks;
	
	private String[] preferredCategories;
	private List<String> enablingDreamIds;
	
	public List<String> getEnablingDreamIds() {
		return enablingDreamIds;
	}
	public void setEnablingDreamIds(List<String> dreamIdsToEnable) {
		this.enablingDreamIds = dreamIdsToEnable;
	}
	public String[] getPreferredCategories() {
		return preferredCategories;
	}
	public void setPreferredCategories(String[] preferredCategories) {
		this.preferredCategories = preferredCategories;
	}
	public String getEnablerDescription() {
		return enablerDescription;
	}
	public void setEnablerDescription(String description) {
		this.enablerDescription = description;
	}
	public String getEnablerTermsOfAgreement() {
		return enablerTermsOfAgreement;
	}
	public void setEnablerTermsOfAgreement(String termsOfAgreement) {
		this.enablerTermsOfAgreement = termsOfAgreement;
	}
	public List<String> getEnablerAchievements() {
		return enablerAchievements;
	}
	public void setEnablerAchievements(List<String> achievements) {
		this.enablerAchievements = achievements;
	}
	public List<String> getEnablerImageKeys() {
		return enablerImageKeys;
	}
	public void setEnablerImageKeys(List<String> imageKeys) {
		this.enablerImageKeys = imageKeys;
	}
	public List<String> getEnablerVideoLinks() {
		return enablerVideoLinks;
	}
	public void setEnablerVideoLinks(List<String> videoLinks) {
		this.enablerVideoLinks = videoLinks;
	}
}
