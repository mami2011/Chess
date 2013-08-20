package com.vendertool.sitewebapp.model;

import java.util.ArrayList;
import java.util.List;

import com.vendertool.sitewebapp.common.FieldEnum;

public class Field {

	private FieldEnum type;
	private String name;
	private String value;
	private List<FieldOption> options;
	private List<Error> errors;
	
	public Field() {
	}
	
	public Field setType(FieldEnum type) {
		this.type = type;
		this.name = type.getName();
		return this;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public Field setValue(String value) {
		this.value = value;
		return this;
	}
	public List<FieldOption> getOptions() {
		return options;
	}
	public void setOptions(List<FieldOption> options) {
		this.options = options;
	}
	public void addOption(FieldOption option) {
		if (this.options == null) {
			this.options = new ArrayList<FieldOption>();
		}
		this.options.add(option);
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	public void addError(Error error) {
		if (this.errors == null) {
			this.errors = new ArrayList<Error>();
		}
		this.errors.add(error);
	}
	
	
	

	
}

