package com.vendertool.sitewebapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {

	private String name;
	private String value;
	private boolean hasError;
	private List<String> errorMessages = Collections.EMPTY_LIST;
	
	public Field(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public Field setValue(String value) {
		this.value = value;
		return this;
	}
	public boolean isHasError() {
		return hasError;
	}
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	public Field setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
		return this;
	}
	public Field addErrorMessage(String errorMessage) {
		if (this.errorMessages.isEmpty()) {
			this.errorMessages = new ArrayList<String>();
		}
		this.errorMessages.add(errorMessage);
		return this;
	}
	
	
}

