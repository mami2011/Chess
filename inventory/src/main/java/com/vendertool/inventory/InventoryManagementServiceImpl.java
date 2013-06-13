package com.vendertool.inventory;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.error.InventoryErrorCode;
import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.error.VTErrorDomainEnum;
import com.vendertool.sharedtypes.error.VTErrorSeverityEnum;
import com.vendertool.sharedtypes.rnr.AddProductImageRequest;
import com.vendertool.sharedtypes.rnr.AddProductImageResponse;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.AddProductVariationRequest;
import com.vendertool.sharedtypes.rnr.AddProductVariationResponse;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityRequest;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityResponse;
import com.vendertool.sharedtypes.rnr.DuplicateProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductVariationResponse;
import com.vendertool.sharedtypes.rnr.RemoveProductResponse;
import com.vendertool.sharedtypes.rnr.RemoveProductVariationResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuanityResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuantityRequest;
import com.vendertool.sharedtypes.rnr.UpdateProductRequest;
import com.vendertool.sharedtypes.rnr.UpdateProductResponse;

@Path("/inventory")
public class InventoryManagementServiceImpl extends BaseVenderToolServiceImpl implements
		IInventoryManagementService {
	
	@GET
	@Path("/getProduct")
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
		response.addError(Errors.INVENTORY.INVALID_PRODUCT_CODE);
		
		return response;
	}

	@POST
	@Path("/addProduct")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddProductResponse addProduct(AddProductRequest request) {
		Product product = request.getProduct();
		System.out.println("/inventory/addproduct/ call. Adding product ... " + product.toString());
		
		AddProductResponse response = new AddProductResponse();
		response.setProductId("P987654321");
		return response;
	}

	@POST
	@Path("/updateProduct")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public UpdateProductResponse updateProduct(UpdateProductRequest request) {
		return null;
	}

	@DELETE
	@Path("/removeProduct")
	@ProduceMime({ "application/xml", "application/json" })
	public RemoveProductResponse removeProduct(String productId) {
		return null;
	}

	@POST
	@Path("/updateProductPriceQuantity")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public UpdateProductPriceQuanityResponse updateProductPriceQuantity(
			UpdateProductPriceQuantityRequest request) {
		return null;
	}

	@POST
	@Path("/adjustQuantity")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AdjustProductQuantityResponse adjustQuantity(
			AdjustProductQuantityRequest request) {
		return null;
	}

	@POST
	@Path("/duplicateProduct")
	@ProduceMime({ "application/xml", "application/json" })
	public DuplicateProductResponse duplicateProduct(String productId) {
		return null;
	}

	@POST
	@Path("/addProductVariation")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddProductVariationResponse addProductVariation(
			AddProductVariationRequest request) {
		return null;
	}

	@DELETE
	@Path("/removeProductVariation")
	@ProduceMime({ "application/xml", "application/json" })
	public RemoveProductVariationResponse removeProductVariation(
			String productId, String variationId) {
		return null;
	}

	@GET
	@Path("/getProductVariation")
	@ProduceMime({ "application/xml", "application/json" })
	public GetProductVariationResponse getProductVariation(@QueryParam("productId")String productId,
			@QueryParam("variationId")String variationId) {
		return null;
	}

	@POST
	@Path("/addProductImage")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddProductImageResponse addProductImage(
			AddProductImageRequest request) {
		return null;
	}
}
