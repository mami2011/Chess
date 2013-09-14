package com.vendertool.sharedtypes.error;

public class CommonErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.COMMON;
	private static CommonErrors INSTANCE = null;
	
	public static synchronized CommonErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new CommonErrors();
		}
		return INSTANCE;
	}
	
	private CommonErrors(){}
	
	//Define errors here
	public VTError NULL_ARGUMENT_PASSED = new VTError(
				CommonErrorCode.NULL_ARGUMENT_PASSED, 
				"Null value passed as arguments", 
				VTErrorSeverityEnum.ERROR, 
				DOMAIN);
}
