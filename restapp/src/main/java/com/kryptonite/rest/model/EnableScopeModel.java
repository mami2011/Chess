package com.kryptonite.rest.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class EnableScopeModel implements Notifiable {

	private String id;	//request id
	private String name;
	private String achieverScopeText;
	private String enablerScopeText;
	private String dateCreated;
	private String dateLastUpdated;
	
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
	public String getAchieverScopeText() {
		return achieverScopeText;
	}
	public void setAchieverScopeText(String achieverScope) {
		this.achieverScopeText = achieverScope;
	}
	public String getEnablerScopeText() {
		return enablerScopeText;
	}
	public void setEnablerScopeText(String enablerScope) {
		this.enablerScopeText = enablerScope;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateLastUpdated() {
		return dateLastUpdated;
	}
	public void setDateLastUpdated(String dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}

}
