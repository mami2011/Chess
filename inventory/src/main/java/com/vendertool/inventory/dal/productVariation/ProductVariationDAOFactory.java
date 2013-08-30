package com.vendertool.inventory.dal.productVariation;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class ProductVariationDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ProductVariationDAOFactorySingletonHelper {
		private static final ProductVariationDAOFactory INSTANCE = new ProductVariationDAOFactory();
	}

	private ProductVariationDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.PRODUCT_VARIATION_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("productVariationDao");
			initialized = true;
		}
	}
	public static ProductVariationDAOFactory getInstance() {
		return ProductVariationDAOFactorySingletonHelper.INSTANCE;
	}

	public ProductVariationDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ProductVariationDao) super.getBaseDAO();
		}
		return null;
	}
}