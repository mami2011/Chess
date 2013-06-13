package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListingErrorCode extends VTErrorCode implements Serializable{
	private static final long serialVersionUID = -6991602080050196818L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public ListingErrorCode(){super("UNKNOWN");}
	
	private ListingErrorCode(String errorCode) {
		super(errorCode);
	}

	@Override
	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}
	
	public static VTErrorCode UNABLE_TO_LIST = new ListingErrorCode(
			"UNABLE_TO_LIST");
	public static VTErrorCode LISTING_HAS_MARKET_ERRORS = new ListingErrorCode(
			"INVALID_PRODUCT");
}
