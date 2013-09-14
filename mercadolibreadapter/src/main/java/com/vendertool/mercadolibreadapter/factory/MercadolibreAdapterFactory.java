package com.vendertool.mercadolibreadapter.factory;

import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.GetListingRequest;

public class MercadolibreAdapterFactory {
	private static class MercadolibreAdapterFactoryHolder {
		private static final MercadolibreAdapterFactory INSTANCE = new MercadolibreAdapterFactory();
	}
	
	private MercadolibreAdapterFactory() {
	}

	public static MercadolibreAdapterFactory getInstance() {
		return MercadolibreAdapterFactoryHolder.INSTANCE;
	}

	public IBaseMercadolibreOperationAdapter getOperationAdapter(
			BaseRequest request) {
		if (request instanceof AddListingRequest) {
			return MercadolibreListingAdapter.getInstance();
		}else if(request instanceof GetListingRequest){
			return MercadolibreGetListingAdapter.getInstance();
		}

		return null;
	}
}