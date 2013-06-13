package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MetadataErrorCode extends VTErrorCode implements Serializable {
	
	private static final long serialVersionUID = 4576977708108595281L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public MetadataErrorCode(){super("UNKNOWN");}
	
	private MetadataErrorCode(String errorCode) {
		super(errorCode);
	}
	
	@Override
	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}

	public static VTErrorCode MARKET_DATA_MISSING = new MetadataErrorCode(
			"MARKET_DATA_MISSING");
}
