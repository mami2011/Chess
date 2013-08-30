package com.vendertool.inventory.dal.productAttribute;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class ProductAttributeDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ProductAttributeDAOFactorySingletonHelper {
		private static final ProductAttributeDAOFactory INSTANCE = new ProductAttributeDAOFactory();
	}

	private ProductAttributeDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.PRODUCT_ATTRIBUTE_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("productAttributeDao");
			initialized = true;
		}
	}
	public static ProductAttributeDAOFactory getInstance() {
		return ProductAttributeDAOFactorySingletonHelper.INSTANCE;
	}

	public ProductAttributeDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ProductAttributeDao) super.getBaseDAO();
		}
		return null;
	}
}