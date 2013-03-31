package com.vendertool.sharedtypes.rnr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.vendertool.sharedtypes.core.VTError;

public class BaseResponse {
	private List<VTError> errors;

	public BaseResponse() {
		errors = new ArrayList<VTError>();
	}
	
	public List<VTError> getErrors() {
		return errors;
	}

	public void setErrors(List<VTError> errors) {
		if(errors == null) {
			throw new IllegalArgumentException(
					"Trying to set null to error, use clearErrors() instead");
		}
		this.errors = errors;
	}
	
	public boolean addError(VTError error) {
		if(error == null) {
			return false;
		}
		
		return this.errors.add(error);
	}
	
	public void clearErrors() {
		this.errors.clear();
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
}
