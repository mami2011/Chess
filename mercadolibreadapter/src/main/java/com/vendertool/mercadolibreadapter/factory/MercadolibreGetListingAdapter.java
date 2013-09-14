package com.vendertool.mercadolibreadapter.factory;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendertool.mercadolibreadapter.add.Item;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.HttpMethodEnum;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

public class MercadolibreGetListingAdapter implements
		IBaseMercadolibreOperationAdapter {

	private static String GET_LISTING_URL = "https://api.mercadolibre.com/items/";

	private MercadolibreGetListingAdapter() {
	}

	private static class MercadolibreGetListingAdapterHolder {
		private static final MercadolibreGetListingAdapter INSTANCE = new MercadolibreGetListingAdapter();
	}
	
	public static MercadolibreGetListingAdapter getInstance() {
		return MercadolibreGetListingAdapterHolder.INSTANCE;
	}

	public BaseResponse execute(BaseRequest request) {
		GetListingRequest itemId = (GetListingRequest)request;
		
		MercadolibreCommunicatorVO communicatorVO = new MercadolibreCommunicatorVO();
		communicatorVO.setMethodEnum(HttpMethodEnum.GET);
		communicatorVO.setMediaType(MediaType.APPLICATION_JSON_TYPE);
		communicatorVO.setTargetURL(GET_LISTING_URL+itemId.getListingId());
		MercadolibreCommunicator communicator = MercadolibreCommunicator.getInstance();
		Response response = communicator.call(communicatorVO);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		
		String output = response.readEntity(String.class);
		Item responseItem = readItem(output);
		
		GetListingResponse getListingResponse = adaptToGetListingResponse(responseItem);
		return getListingResponse;
	}

	private GetListingResponse adaptToGetListingResponse(Item responseItem) {
		if(responseItem == null){
			return null;
		}
		GetListingResponse response = new GetListingResponse();
		
		Listing listing = new Listing();
		
		listing.setCondition(responseItem.getCondition());
		listing.setPrice(new Amount());
		listing.setQuantity(responseItem.getAvailable_quantity().intValue());
		Product product = new Product();
//		product.setDescription(responseItem.getDescriptions());
		product.setTitle(responseItem.getTitle());
		listing.setProduct(product);
		response.setListing(listing);
		return response;
	}

	private Item readItem(String output) {
		Item response = null;
		try {
			response = new ObjectMapper().readValue(output, Item.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}