package com.vendertool.listing.helper;

import java.util.HashMap;
import java.util.Map;

public class ListingHelperRegistry {

	private static Map<ListingHelperTypeEnum, BaseListingHelper> s_registry;

	// To make Singleton *** Start ***
	private static class ListingHelperRegistryHolder {
		private static final ListingHelperRegistry INSTANCE = new ListingHelperRegistry();
	}

	private ListingHelperRegistry() {
		s_registry = new HashMap<ListingHelperTypeEnum, BaseListingHelper>();
	}

	public static ListingHelperRegistry getInstance() {
		return ListingHelperRegistryHolder.INSTANCE;
	}

	// To make Singleton *** End ***
	public BaseListingHelper getHelper(ListingHelperTypeEnum key) {
		BaseListingHelper helper = null;
		if (key != null) {
			helper = s_registry.get(key);
		}
		return helper;
	}

	public void register(ListingHelperTypeEnum key, BaseListingHelper factory) {
		if (key != null) {
			s_registry.put(key, factory);
		}
	}
}