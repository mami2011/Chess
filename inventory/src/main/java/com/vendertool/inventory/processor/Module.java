package com.vendertool.inventory.processor;


public class Module {

	private static class ModuleHolder {
		private static final Module INSTANCE = new Module();
	}

	public static Module getInstance() {
		return ModuleHolder.INSTANCE;
	}

	private Module() {
		
	}

	public void init() {
		//All helpers needs to be registered here.
		AddProductProcessor.getInstance().register();
		GetProductProcessor.getInstance().register();
		AdjustProductQuantityProcessor.getInstance().register();
		DuplicateProductProcessor.getInstance().register();
		RemoveProductProcessor.getInstance().register();
		UpdateProductPriceQuantityProcessor.getInstance().register();
		UpdateProductProcessor.getInstance().register();
	}
}
