package com.vendertool.sharedtypes.error;

public class ListingErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.LISTING;
	private static ListingErrors INSTANCE = null;
	
	public static synchronized ListingErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new ListingErrors();
		}
		return INSTANCE;
	}
	
	private ListingErrors(){}
	
	//Define errors here
	public VTError LISTING_HAS_MARKET_ERRORS = new VTError(
			ListingErrorCode.LISTING_HAS_MARKET_ERRORS, 
			"Unbale to list due to market errors", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}
