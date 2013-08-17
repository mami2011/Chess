package com.vendertool.sitewebapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.vendertool.sitewebapp.common.FieldEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Field {

	private FieldEnum type;
	private String value;
	private boolean hasError;
	private List<String> errorMessages = Collections.EMPTY_LIST;
	
	public Field() {
	}
	
	public Field setType(FieldEnum type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return type.getName();
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

