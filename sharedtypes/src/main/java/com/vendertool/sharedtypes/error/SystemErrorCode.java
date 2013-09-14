package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SystemErrorCode extends VTErrorCode implements Serializable {
	private static final long serialVersionUID = 6984336442439721886L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public SystemErrorCode(){super("UNKNOWN");}
	
	private SystemErrorCode(String errorCode) {
		super(errorCode);
	}

	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}
	
	public static VTErrorCode VT_WEBSERVICE_NETWORK_TIMEOUT = new SystemErrorCode(
			"VT_WEBSERVICE_NETWORK_TIMEOUT");
	public static VTErrorCode MARKETPLACE_WEBSERVICE_NETWORK_TIMEOUT = new SystemErrorCode(
			"MARKETPLACE_WEBSERVICE_NETWORK_TIMEOUT");
	public static VTErrorCode INTERNAL_DATABASE_DOWN = new SystemErrorCode(
			"INTERNAL_DATABASE_DOWN");
	//This is a catch all, use it sparingly
	public static VTErrorCode INTERNAL_ERROR = new SystemErrorCode(
			"INTERNAL_ERROR");
	public static VTErrorCode DOWN_FOR_MAINTAINENCE = new SystemErrorCode(
			"DOWN_FOR_MAINTAINENCE");
}
