package com.vendertool.inventory.dal.product;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class ProductDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ProductDAOFactorySingletonHelper {
		private static final ProductDAOFactory INSTANCE = new ProductDAOFactory();
	}

	private ProductDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.PRODUCT_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("productDao");
			initialized = true;
		}
	}
	public static ProductDAOFactory getInstance() {
		return ProductDAOFactorySingletonHelper.INSTANCE;
	}

	public ProductDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ProductDao) super.getBaseDAO();
		}
		return null;
	}
}