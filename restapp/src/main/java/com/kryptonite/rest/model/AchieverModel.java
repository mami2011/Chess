package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class AchieverModel {

	private List<String> enablerUserIds;		//enablers currently enabling this achiever
	private List<String> dreamIds;
	
	public List<String> getDreamIds() {
		return dreamIds;
	}

	public void setDreamIds(List<String> dreamIds) {
		this.dreamIds = dreamIds;
	}

	public List<String> getEnablerUserIds() {
		return enablerUserIds;
	}

	public void setEnablerUserIds(List<String> enablerIds) {
		this.enablerUserIds = enablerIds;
	}
}
