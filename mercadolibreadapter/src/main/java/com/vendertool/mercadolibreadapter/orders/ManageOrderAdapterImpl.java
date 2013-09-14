package com.vendertool.mercadolibreadapter.orders;

public class ManageOrderAdapterImpl {

	private static class ManageOrderImplHolder {
		private static final ManageOrderAdapterImpl INSTANCE = new ManageOrderAdapterImpl();
	}

	private ManageOrderAdapterImpl() {

	}

	public static ManageOrderAdapterImpl getInstance() {
		return ManageOrderImplHolder.INSTANCE;
	}
	
}