package com.vendertool.inventory.dal.bof;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.inventory.dal.product.ProductDAOFactory;
import com.vendertool.inventory.dal.product.ProductDao;
import com.vendertool.inventory.dal.productVariation.ProductVariationDAOFactory;
import com.vendertool.inventory.dal.productVariation.ProductVariationDao;
import com.vendertool.sharedtypes.core.Dimension;
import com.vendertool.sharedtypes.core.NameValuePair;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.ProductVariation;
import com.vendertool.sharedtypes.core.Weight;

public class ProductBof {

	private static final Logger logger = Logger.getLogger(ProductBof.class
			.getName());

	private ProductDao productDAO;
	private ProductVariationDao productVariationDAO;

	// To make Singleton *** Start ***
	private static class ProductBofSingletonHolder {
		private static final ProductBof INSTANCE = new ProductBof();
	}

	private ProductBof() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.PRODUCT_DAO);
		if (baseFactory != null) {
			ProductDAOFactory productDAOFactory = (ProductDAOFactory) baseFactory;
			productDAO = productDAOFactory.getDAO();
		} else {
			// TODO log
		}
		baseFactory = DAOFactoryRegistry.getInstance().getFactory(
				DAOFactoryKey.PRODUCT_VARIATION_DAO);
		if (baseFactory != null) {
			ProductVariationDAOFactory productVariationDAOFactory = (ProductVariationDAOFactory) baseFactory;
			productVariationDAO = productVariationDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static ProductBof getInstance() {
		return ProductBofSingletonHolder.INSTANCE;
	}

	public void insert(Product product) {
		// Insert Into Product.
		com.vendertool.inventory.dal.product.Product productDO = new com.vendertool.inventory.dal.product.Product();
		// TODO how to get account ID
		productDO.setProductId(12122l);
		productDO.setAccountId(112233l);

		productDO.setAvailbleQuantity(product.getQuantity());
		productDO.setDescriptionText(product.getDescription());
		// productDO.setLastModifiedApp(product.get);
		productDO.setPrice(product.getPrice().getValue());
		productDO.setProductCode(product.getProductCode());
		productDO.setProductCodeType((byte) product.getProductCodeType()
				.getId());
		// productDO.setProductcol(productcol);
		// Set Dimensions
		setDimensions(product.getDimension(), productDO);
		setWeight(product.getWeight(), productDO);
		productDO.setTitle(product.getSku());
		productDO.setSku(product.getSku());
		// productDO.setProductUrl(product.g);
		// TODO set all values
		productDAO.insert(productDO);
		List<ProductVariation> productVariations = product.getVariations();
		if (productVariations != null && productVariations.size() > 0) {
			for (ProductVariation productVariation : productVariations) {
				if (productVariation == null) {
					continue;
				}
				insertProductVariation(productDO.getProductId(),
						productVariation);
			}
		}

		List<NameValuePair> properties = product.getProperties();
		if (properties != null && properties.size() > 0) {
			for(NameValuePair property : properties){
				if(property == null){
					continue;
				}
				
			}
		}
	}

	private void insertProductVariation(Long productId,
			ProductVariation productVariation) {
		com.vendertool.inventory.dal.productVariation.ProductVariation productVariationDO = new com.vendertool.inventory.dal.productVariation.ProductVariation();
		productVariationDO.setAvailbleQuantity(productVariation.getQuantity());
		productVariationDO.setPrice(productVariation.getPrice().getValue());
		productVariationDO.setProductId(productId);
		productVariationDO.setTitle(productVariation.getTitle());
		// productVariationDO.setUrl(url)
		productVariationDAO.insert(productVariationDO);
	}

	private void setWeight(Weight weight,
			com.vendertool.inventory.dal.product.Product productDO) {
		if (weight != null) {
			productDO.setWeightUnit((byte) weight.getWeightUnit().getId());
			productDO.setWeight(BigDecimal.valueOf(weight.getValue()));
		}
	}

	private void setDimensions(Dimension dim,
			com.vendertool.inventory.dal.product.Product productDO) {
		if (dim == null) {
			return;
		}
		productDO.setWidth(BigDecimal.valueOf(dim.getWidth()));
		productDO.setHeight(BigDecimal.valueOf(dim.getHeight()));
		productDO.setLength(BigDecimal.valueOf(dim.getLength()));
		productDO.setDimensionUnit((byte) dim.getDimensionUnit().getId());
	}
}