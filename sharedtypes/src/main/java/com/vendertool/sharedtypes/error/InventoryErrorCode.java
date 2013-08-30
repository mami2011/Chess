package com.vendertool.sharedtypes.error;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryErrorCode extends VTErrorCode implements Serializable {
	
	private static final long serialVersionUID = 5229362714419873344L;
	
	private static Set<String> ALL_ERROR_CODES = new HashSet<String>();
	
	public InventoryErrorCode(){super("UNKNOWN");}
	
	private InventoryErrorCode(String errorCode) {
		super(errorCode);
	}

	public Set<String> getCachedErrorCodes() {
		return ALL_ERROR_CODES;
	}
	
	public static VTErrorCode MISSING_TITLE = new InventoryErrorCode(
			"MISSING_TITLE");
	public static VTErrorCode TITLE_CONTAINS_INVALID_TOKENS = new InventoryErrorCode(
			"TITLE_CONTAINS_INVALID_TOKENS");
	public static VTErrorCode DESC_CONTAINS_INVALID_TOKENS = new InventoryErrorCode(
			"DESC_CONTAINS_INVALID_TOKENS");
	public static VTErrorCode DUPLICATE_SKU = new InventoryErrorCode(
			"DUPLICATE_SKU");
	public static VTErrorCode MIN_PRICE_LIMIT = new InventoryErrorCode(
			"MIN_PRICE_LIMIT");
	public static VTErrorCode MAX_PRICE_LIMIT = new InventoryErrorCode(
			"MAX_PRICE_LIMIT");
	public static VTErrorCode INVALID_PRODUCT_CODE = new InventoryErrorCode(
			"INVALID_PRODUCT_CODE");
	public static VTErrorCode MAX_QUANTITY_LIMIT = new InventoryErrorCode(
			"MAX_QUANTITY_LIMIT");
	public static VTErrorCode MAX_IMAGE_COUNT_LIMIT = new InventoryErrorCode(
			"MAX_IMAGE_COUNT_LIMIT");
	public static VTErrorCode IMAGE_FORMAT_NOT_SUPPORTED = new InventoryErrorCode(
			"IMAGE_FORMAT_NOT_SUPPORTED");
	public static VTErrorCode IMAGE_QUALITY_NOT_GOOD = new InventoryErrorCode(
			"IMAGE_QUALITY_NOT_GOOD");
	public static VTErrorCode MISSING_PRICE = new InventoryErrorCode(
			"MISSING_PRICE");
	public static VTErrorCode MISSING_SKU = new InventoryErrorCode(
			"MISSING_SKU");
	public static VTErrorCode MISSING_PRODUCT_CODE = new InventoryErrorCode(
			"MISSING_PRODUCT_CODE");
	public static VTErrorCode MISSING_PRODUCT_CODE_TYPE = new InventoryErrorCode(
			"MISSING_PRODUCT_CODE_TYPE");
	public static VTErrorCode INVALID_QUANTITY = new InventoryErrorCode(
			"INVALID_QUANTITY");
}