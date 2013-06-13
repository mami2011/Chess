package com.vendertool.sharedtypes.error;

public class MetadataErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.METADATA;
	private static MetadataErrors INSTANCE = null;
	
	public static synchronized MetadataErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new MetadataErrors();
		}
		return INSTANCE;
	}
	
	private MetadataErrors(){}
	
	
	//Define errors here
	public VTError MARKET_DATA_MISSING = new VTError(
			MetadataErrorCode.MARKET_DATA_MISSING, 
			"Missing market input", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}
