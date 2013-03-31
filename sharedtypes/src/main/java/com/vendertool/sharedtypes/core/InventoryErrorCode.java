package com.vendertool.sharedtypes.core;

import java.util.HashSet;
import java.util.Set;

public class InventoryErrorCode extends VTErrorCode {
	private static Set<String> allInventoryErrorcodes = new HashSet<String>();
	
	public InventoryErrorCode(String errorCode) {
		super(errorCode);
	}

	public Set<String> getCachedErrorCodes() {
		return allInventoryErrorcodes;
	}
	
	public static VTErrorCode INSUFFICIENT_PRODUCT_INFORMATION = new InventoryErrorCode(
			"INSUFFICIENT_PRODUCT_INFORMATION");
	public static VTErrorCode INVALID_PRODUCT = new InventoryErrorCode(
			"INVALID_PRODUCT");
	public static VTErrorCode PRODUCT_TITLE_MISSING = new InventoryErrorCode(
			"PRODUCT_TITLE_MISSING");
}
