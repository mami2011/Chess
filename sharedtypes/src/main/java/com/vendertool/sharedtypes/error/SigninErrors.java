package com.vendertool.sharedtypes.error;

public class SigninErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.SIGNIN;
	private static SigninErrors INSTANCE = null;
	
	public static synchronized SigninErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new SigninErrors();
		}
		return INSTANCE;
	}
	
	private SigninErrors(){}
	
	//Define errors here
	public VTError INVALID_USERNAME_OR_PASSWORD = new VTError(
			SigninErrorCode.INVALID_USERNAME_OR_PASSWORD, 
			"Username or password is not valid", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError USERNAME_DOES_NOT_EXIST = new VTError(
			SigninErrorCode.USERNAME_DOES_NOT_EXIST, 
			"Username does not exist", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError UNABLE_TO_SIGN_IN = new VTError(
			SigninErrorCode.UNABLE_TO_SIGN_IN, 
			"Username does not exist", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}
