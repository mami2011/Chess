package com.vendertool.inventory.dal.bof;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.inventory.dal.product.ProductDAOFactory;
import com.vendertool.inventory.dal.product.ProductDao;
import com.vendertool.sharedtypes.core.Product;

public class ProductBof {

	private static final Logger logger = Logger.getLogger(ProductBof.class
			.getName());

	private ProductDao dao;

	// To make Singleton *** Start ***
	private static class ProductBofSingletonHolder {
		private static final ProductBof INSTANCE = new ProductBof();
	}

	private ProductBof() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.PRODUCT_DAO);
		if (baseFactory != null) {
			ProductDAOFactory productDAOFactory = (ProductDAOFactory) baseFactory;
			dao = productDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static ProductBof getInstance() {
		return ProductBofSingletonHolder.INSTANCE;
	}
	
	public void insert(Product product){
		com.vendertool.inventory.dal.product.Product productDO = new com.vendertool.inventory.dal.product.Product();
		/*productDO.setAccountId(accountId);
		productDO.setAvailbleQuantity(availbleQuantity);
		productDO.setLength(length);
		*/
		//TODO set all values
		dao.insert(productDO);
	}
}