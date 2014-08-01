package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class EnablerModel {

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
}
