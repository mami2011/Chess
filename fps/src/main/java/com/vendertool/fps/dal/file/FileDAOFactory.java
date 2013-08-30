package com.vendertool.fps.dal.file;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class FileDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class FileDAOFactorySingletonHelper {
		private static final FileDAOFactory INSTANCE = new FileDAOFactory();
	}

	private FileDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.FILE_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("fileDao");
			initialized = true;
		}
	}
	public static FileDAOFactory getInstance() {
		return FileDAOFactorySingletonHelper.INSTANCE;
	}

	public FileDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (FileDao) super.getBaseDAO();
		}
		return null;
	}
}