package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class CategoryModel  {

	private String id;
	private String parentId;
	private String name;
	private boolean isActive = true;
	private List<String> tags;
	private List<String> childIds;
	private List<String> scopeIds;
	private List<EnableScopeModel> scopeList;
	
	@JsonIgnore
	private Node parentNode;
	private List<Node> childNodes;
	@JsonIgnore
	private List<Node> scopeNodeList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<String> getScopeIds() {
		return scopeIds;
	}
	public void setScopeIds(List<String> scopeIds) {
		this.scopeIds = scopeIds;
	}
	public List<EnableScopeModel> getScopeList() {
		return scopeList;
	}
	public void setScopeList(List<EnableScopeModel> scopeList) {
		this.scopeList = scopeList;
	}
	public List<String> getChildIds() {
		return childIds;
	}
	public void setChildIds(List<String> childIds) {
		this.childIds = childIds;
	}
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	public List<Node> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}
	public List<Node> getScopeNodeList() {
		return scopeNodeList;
	}
	public void setScopeNodeList(List<Node> scopeNodeList) {
		this.scopeNodeList = scopeNodeList;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
