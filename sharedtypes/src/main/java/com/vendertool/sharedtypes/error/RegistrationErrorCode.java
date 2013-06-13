package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegistrationErrorCode extends VTErrorCode implements Serializable{

	private static final long serialVersionUID = 6659050189299043583L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public RegistrationErrorCode(){super("UNKNOWN");}
	
	private RegistrationErrorCode(String errorCode) {
		super(errorCode);
	}
	
	@Override
	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}

	public static VTErrorCode INVALID_EMAIL_ID = new RegistrationErrorCode(
			"INVALID_EMAIL_ID");
	public static VTErrorCode INVALID_LASTNAME = new RegistrationErrorCode(
			"INVALID_LASTNAME");
	public static VTErrorCode INVALID_FIRSTNAME = new RegistrationErrorCode(
			"INVALID_FIRSTNAME");
	public static VTErrorCode INVALID_PHONE_FORMAT = new RegistrationErrorCode(
			"INVALID_PHONE_FORMAT");
	public static VTErrorCode MISSING_ADDRESS_FIRSTLINE = new RegistrationErrorCode(
			"MISSING_ADDRESS_FIRSTLINE");
	public static VTErrorCode INVALID_ADDRESS_COUNTRY_ZIP = new RegistrationErrorCode(
			"INVALID_ADDRESS_COUNTRY_ZIP");
	public static VTErrorCode INVALID_ADDRESS_STATE_PROVINCE = new RegistrationErrorCode(
			"INVALID_ADDRESS_STATE_PROVINCE");
	public static VTErrorCode INVALID_ADDRESS_CITY_PROVINCE = new RegistrationErrorCode(
			"INVALID_ADDRESS_CITY_PROVINCE");
	
}
