package com.vendertool.sharedtypes.error;

public class RegistrationErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.REGISTRATION;
	private static RegistrationErrors INSTANCE = null;
	
	public static synchronized RegistrationErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new RegistrationErrors();
		}
		return INSTANCE;
	}
	
	private RegistrationErrors(){}
	
	//Define errors here
	public VTError INVALID_EMAIL_ID = new VTError(
			RegistrationErrorCode.INVALID_EMAIL_ID, 
			"Email id is not in a valid format", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_LASTNAME = new VTError(
			RegistrationErrorCode.INVALID_LASTNAME, 
			"Last name has invalid characters", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_FIRSTNAME = new VTError(
			RegistrationErrorCode.INVALID_FIRSTNAME, 
			"First name has invalid characters", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_PHONE_FORMAT = new VTError(
			RegistrationErrorCode.INVALID_PHONE_FORMAT, 
			"Invalid phone number fomat", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError MISSING_ADDRESS_FIRSTLINE = new VTError(
			RegistrationErrorCode.MISSING_ADDRESS_FIRSTLINE, 
			"Address line one is missing", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_ADDRESS_COUNTRY_ZIP = new VTError(
			RegistrationErrorCode.INVALID_ADDRESS_COUNTRY_ZIP, 
			"Invalid address country and zip combination", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_ADDRESS_STATE_PROVINCE = new VTError(
			RegistrationErrorCode.INVALID_ADDRESS_STATE_PROVINCE, 
			"Invalid address state or province", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_ADDRESS_CITY_PROVINCE = new VTError(
			RegistrationErrorCode.INVALID_ADDRESS_CITY_PROVINCE, 
			"Invalid address city or province", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}
