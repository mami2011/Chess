package com.vendertool.sitewebapp.model;

import java.util.List;
import java.util.Map;

import com.vendertool.sitewebapp.common.FieldEnum;

public class Page {

	private String username;
	private Map<FieldEnum, Field> fieldMap;
	private List<Error> pageErrors;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<FieldEnum, Field> getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(Map<FieldEnum, Field> fieldMap) {
		this.fieldMap = fieldMap;
	}
	public List<Error> getPageErrors() {
		return pageErrors;
	}
	public void setPageErrors(List<Error> pageErrors) {
		this.pageErrors = pageErrors;
	}
	
	
}
