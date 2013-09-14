package com.vendertool.listing.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;

public class ListingProcessorFactory {

	private static final Logger logger = Logger
			.getLogger(ListingProcessorFactory.class);

	public static BaseListingProcessor getListingProcessor(
			ListingProcessorTypeEnum processorTypeEnum) {
		BaseListingProcessor helper = ListingProcessorRegistry.getInstance()
				.getProcessor(processorTypeEnum);
		if (helper == null) {
			VTRuntimeException ex = new VTRuntimeException(
					" getListingHelper in ListingHelperFactory -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ processorTypeEnum);
			logger.debug(
					" getListingHelper in ListingHelperFactory -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ processorTypeEnum, ex);
			throw ex;
		}
		return helper;
	}
}