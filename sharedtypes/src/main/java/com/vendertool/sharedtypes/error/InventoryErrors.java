package com.vendertool.sharedtypes.error;

public class InventoryErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.INVENTORY;
	private static InventoryErrors INSTANCE = null;
	
	public static synchronized InventoryErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new InventoryErrors();
		}
		return INSTANCE;
	}
	
	private InventoryErrors(){}
	
	//Define errors here
	public VTError MISSING_TITLE = new VTError(
				InventoryErrorCode.MISSING_TITLE, 
				"Product title is missing", 
				VTErrorSeverityEnum.ERROR, 
				DOMAIN);
	
	public VTError TITLE_CONTAINS_INVALID_TOKENS = new VTError(
			InventoryErrorCode.TITLE_CONTAINS_INVALID_TOKENS, 
			"Product title contains invalid tokens", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError DESC_CONTAINS_INVALID_TOKENS = new VTError(
			InventoryErrorCode.DESC_CONTAINS_INVALID_TOKENS, 
			"Product description contains invalid tokens", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError DUPLICATE_SKU = new VTError(
			InventoryErrorCode.DUPLICATE_SKU, 
			"Product SKU already exists", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError MIN_PRICE_LIMIT = new VTError(
			InventoryErrorCode.MIN_PRICE_LIMIT, 
			"Product price is below minimum threshold", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError MAX_PRICE_LIMIT = new VTError(
			InventoryErrorCode.MAX_PRICE_LIMIT, 
			"Product price is above maximum limit", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_PRODUCT_CODE = new VTError(
			InventoryErrorCode.INVALID_PRODUCT_CODE, 
			"Product code is invalid", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError MAX_QUANTITY_LIMIT = new VTError(
			InventoryErrorCode.MAX_QUANTITY_LIMIT, 
			"Product quantity exceeds maximum limit", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError MAX_IMAGE_COUNT_LIMIT = new VTError(
			InventoryErrorCode.MAX_IMAGE_COUNT_LIMIT, 
			"Product title is missing", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError IMAGE_FORMAT_NOT_SUPPORTED = new VTError(
			InventoryErrorCode.IMAGE_FORMAT_NOT_SUPPORTED, 
			"Product image format not supported", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError IMAGE_QUALITY_NOT_GOOD = new VTError(
			InventoryErrorCode.IMAGE_QUALITY_NOT_GOOD, 
			"Product image quality is very poor", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
}
