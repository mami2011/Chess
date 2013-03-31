package com.vendertool.inventory;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import com.vendertool.sharedtypes.core.InventoryErrorCode;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.VTError;
import com.vendertool.sharedtypes.core.VTErrorDomain;
import com.vendertool.sharedtypes.core.VTErrorSeverity;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductResponse;

@Path("/inventory")
public class InventoryManagementServiceImpl implements
		IInventoryManagementService {

	@GET
	@ProduceMime({ "application/xml", "application/json" })
	public GetProductResponse getProduct(@QueryParam("productId") String id) {
		GetProductResponse response = new GetProductResponse();
		Product product = new Product("iPhone 5");
		String pid = "P123456789";
		if(id == null) {
			id = pid;
		}
		product.setProductId(id);
		response.setProduct(product);
		response.addError(new VTError(
				InventoryErrorCode.INSUFFICIENT_PRODUCT_INFORMATION,
				"Insuffient product information", VTErrorSeverity.WARNING,
				VTErrorDomain.INVENTORY));
		
		return response;
	}

	@POST
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddProductResponse addProduct(AddProductRequest request) {
		Product product = request.getProduct();
		System.out.println("/inventory/addproduct/ call. Adding product ... " + product.toString());
		
		AddProductResponse response = new AddProductResponse();
		response.setProductId("P987654321");
		return response;
	}

}
