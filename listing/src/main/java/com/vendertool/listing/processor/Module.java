package com.vendertool.listing.processor;

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
		AddListingProcessor.getInstance().register();
		DuplicateListingProcessor.getInstance().register();
		EndListingProcessor.getInstance().register();
		GetAuctionBidCountProcessor.getInstance().register();
		GetAuctionHighBidderProcessor.getInstance().register();
		GetListingProcessor.getInstance().register();
		GetListingPriceQuantityProcessor.getInstance().register();
		VerifyListingProcessor.getInstance().register();
		AdjustListingQuantityProcessor.getInstance().register();
		UpdateListingProcessor.getInstance().register();
		UpdateListingPriceQuantityProcessor.getInstance().register();
	}
}