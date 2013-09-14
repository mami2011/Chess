package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;

public class InventoryProcessorFactory {

	private static final Logger logger = Logger
			.getLogger(InventoryProcessorFactory.class);

	public static BaseInventoryProcessor getInventoryProcessor(
			InventoryProcessorTypeEnum processorTypeEnum) {
		BaseInventoryProcessor helper = InventoryProcessorRegistry
				.getInstance().getProcessor(processorTypeEnum);
		if (helper == null) {
			VTRuntimeException ex = new VTRuntimeException(
					" getListingHelper in BaseInventoryProcessor -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ processorTypeEnum);
			logger.debug(
					" getListingHelper in BaseInventoryProcessor -- No object availalbe for Key  (Make sure if the helper is registered in Module) : "
							+ processorTypeEnum, ex);
			throw ex;
		}
		return helper;
	}
}