package com.vendertool.listing.helper;

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
		AddListingHelper.getInstance().register();
		DuplicateListingHelper.getInstance().register();
		EndListingHelper.getInstance().register();
		GetAuctionBidCountHelper.getInstance().register();
		GetAuctionHighBidderHelper.getInstance().register();
		GetListingHelper.getInstance().register();
		GetListingPriceQuantityHelper.getInstance().register();
		VerifyListingHelper.getInstance().register();
		AdjustListingQuantityHelper.getInstance().register();
		UpdateListingHelper.getInstance().register();
		UpdateListingPriceQuantityHelper.getInstance().register();
	}
}