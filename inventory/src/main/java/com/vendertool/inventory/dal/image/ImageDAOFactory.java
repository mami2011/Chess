package com.vendertool.inventory.dal.image;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class ImageDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ImageDAOFactorySingletonHelper {
		private static final ImageDAOFactory INSTANCE = new ImageDAOFactory();
	}

	private ImageDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.IMAGE_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("imageDao");
			initialized = true;
		}
	}
	public static ImageDAOFactory getInstance() {
		return ImageDAOFactorySingletonHelper.INSTANCE;
	}

	public ImageDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ImageDao) super.getBaseDAO();
		}
		return null;
	}
}