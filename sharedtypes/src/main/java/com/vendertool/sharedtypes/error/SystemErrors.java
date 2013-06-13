package com.vendertool.sharedtypes.error;

public class SystemErrors {
	
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.SYSTEM;
	private static SystemErrors INSTANCE = null;
	
	
	public static synchronized SystemErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new SystemErrors();
		}
		return INSTANCE;
	}
	
	private SystemErrors(){}
	
	
	//Define errors here
	public VTError VT_WEBSERVICE_NETWORK_TIMEOUT = new VTError(
				SystemErrorCode.VT_WEBSERVICE_NETWORK_TIMEOUT, 
				"Network timed out while invoking the webservice", 
				VTErrorSeverityEnum.ERROR, 
				DOMAIN);
	
	public VTError MARKETPLACE_WEBSERVICE_NETWORK_TIMEOUT = new VTError(
			SystemErrorCode.MARKETPLACE_WEBSERVICE_NETWORK_TIMEOUT, 
			"Marketplace network is down", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INTERNAL_DATABASE_DOWN = new VTError(
			SystemErrorCode.INTERNAL_DATABASE_DOWN, 
			"Internal database system is down", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);

	//This is a catch all, use it sparingly
	public VTError INTERNAL_ERROR = new VTError(
			SystemErrorCode.INTERNAL_ERROR, 
			"Unknown internal error has occurred", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError DOWN_FOR_MAINTAINENCE = new VTError(
			SystemErrorCode.DOWN_FOR_MAINTAINENCE, 
			"The systems are down for maintainence, we should be back up shortly, sorry for the inconvenience", 
			VTErrorSeverityEnum.INFO, 
			DOMAIN);
}
