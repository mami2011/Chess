package com.vendertool.inventory.processor;

import java.util.HashMap;
import java.util.Map;

public class InventoryProcessorRegistry {
	private static Map<InventoryProcessorTypeEnum, BaseInventoryProcessor> s_registry;

	// To make Singleton *** Start ***
	private static class InventoryProcessorRegistryHolder {
		private static final InventoryProcessorRegistry INSTANCE = new InventoryProcessorRegistry();
	}

	private InventoryProcessorRegistry() {
		s_registry = new HashMap<InventoryProcessorTypeEnum, BaseInventoryProcessor>();
	}

	public static InventoryProcessorRegistry getInstance() {
		return InventoryProcessorRegistryHolder.INSTANCE;
	}

	// To make Singleton *** End ***
	public BaseInventoryProcessor getProcessor(InventoryProcessorTypeEnum key) {
		BaseInventoryProcessor helper = null;
		if (key != null) {
			helper = s_registry.get(key);
		}
		return helper;
	}

	public void register(InventoryProcessorTypeEnum key, BaseInventoryProcessor factory) {
		if (key != null) {
			s_registry.put(key, factory);
		}
	}
}