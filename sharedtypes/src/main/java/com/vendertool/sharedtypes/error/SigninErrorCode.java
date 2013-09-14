package com.vendertool.sharedtypes.error;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SigninErrorCode extends VTErrorCode {

	private static final long serialVersionUID = 6659050189299043583L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public SigninErrorCode(){super("UNKNOWN");}
	
	private SigninErrorCode(String errorCode) {
		super(errorCode);
	}
	
	@Override
	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}

	public static VTErrorCode INVALID_USERNAME_OR_PASSWORD = new SigninErrorCode(
			"INVALID_USERNAME_OR_PASSWORD");
	
	public static VTErrorCode USERNAME_DOES_NOT_EXIST = new SigninErrorCode(
			"USERNAME_DOES_NOT_EXIST");
	
	public static VTErrorCode UNABLE_TO_SIGN_IN = new SigninErrorCode(
			"UNABLE_TO_SIGN_IN");
}
