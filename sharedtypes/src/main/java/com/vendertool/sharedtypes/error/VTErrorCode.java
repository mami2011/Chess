package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.vendertool.sharedtypes.exception.DuplicateException;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class VTErrorCode implements Serializable{
	private String errorCode;

	public VTErrorCode(String code) {
		setErrorCode(code);
	}
	
	public abstract Set<String> getCachedErrorCodes();
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		if((errorCode == null) || (errorCode.trim().isEmpty())){
			throw new DuplicateException("Error Code cannot be empty or null");
		}
		
		Set<String> allcodes = getCachedErrorCodes();
		
		if(allcodes.contains(errorCode)) {
			throw new DuplicateException("Duplicate error code: " + errorCode);
		}
		
		this.errorCode = errorCode;
		allcodes.add(errorCode);
	}
	
	public boolean hasErrorCode(String errorCode) {
		return getCachedErrorCodes().contains(errorCode);
	}
	
	private static final long serialVersionUID = 7704847642408908964L;
}
