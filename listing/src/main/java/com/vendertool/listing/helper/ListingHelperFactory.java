package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;

public class ListingHelperFactory {

	private static final Logger logger = Logger
			.getLogger(ListingHelperFactory.class);

	public static BaseListingHelper getListingHelper(
			ListingHelperTypeEnum helperTypeEnum) {
		BaseListingHelper helper = ListingHelperRegistry.getInstance()
				.getHelper(helperTypeEnum);
		if (helper == null) {
			VTRuntimeException ex = new VTRuntimeException(
					" getListingHelper in ListingHelperFactory -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ helperTypeEnum);
			logger.debug(
					" getListingHelper in ListingHelperFactory -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ helperTypeEnum, ex);
			throw ex;
		}
		return helper;
	}
}