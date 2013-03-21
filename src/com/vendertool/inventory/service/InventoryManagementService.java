package com.vendertool.inventory.service;

import com.vendertool.common.types.rnr.CreateProductRequest;
import com.vendertool.common.types.rnr.CreateProductResponse;

public interface InventoryManagementService {
	public CreateProductResponse createProduct(CreateProductRequest request);

}
