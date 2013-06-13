package com.vendertool.sharedtypes.error;

//This is a navigation'al container
//Example usage: addError(Errors.SYSTEM.VT_WEBSERVICE_NETWORK_TIMEOUT);
public interface Errors {
	public static SystemErrors SYSTEM = SystemErrors.getInstance();
	public static InventoryErrors INVENTORY = InventoryErrors.getInstance();
	public static ListingErrors LISTING = ListingErrors.getInstance();
	public static MetadataErrors METADATA = MetadataErrors.getInstance();
	public static RegistrationErrors REGISTRATION = RegistrationErrors.getInstance();
	public static SigninErrors SIGNIN = SigninErrors.getInstance();
	public static FTSErrors FTS = FTSErrors.getInstance();
}
