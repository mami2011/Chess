package com.vendertool.inventory;

import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductRequest;
import com.vendertool.sharedtypes.rnr.GetProductResponse;

public interface IInventoryManagementService {
	public GetProductResponse getProduct(String id);

	public AddProductResponse addProduct(AddProductRequest request);

}
