package com.vendertool.listing.processor;

import java.util.HashMap;
import java.util.Map;

public class ListingProcessorRegistry {

	private static Map<ListingProcessorTypeEnum, BaseListingProcessor> s_registry;

	// To make Singleton *** Start ***
	private static class ListingHelperRegistryHolder {
		private static final ListingProcessorRegistry INSTANCE = new ListingProcessorRegistry();
	}

	private ListingProcessorRegistry() {
		s_registry = new HashMap<ListingProcessorTypeEnum, BaseListingProcessor>();
	}

	public static ListingProcessorRegistry getInstance() {
		return ListingHelperRegistryHolder.INSTANCE;
	}

	// To make Singleton *** End ***
	public BaseListingProcessor getProcessor(ListingProcessorTypeEnum key) {
		BaseListingProcessor helper = null;
		if (key != null) {
			helper = s_registry.get(key);
		}
		return helper;
	}

	public void register(ListingProcessorTypeEnum key, BaseListingProcessor factory) {
		if (key != null) {
			s_registry.put(key, factory);
		}
	}
}