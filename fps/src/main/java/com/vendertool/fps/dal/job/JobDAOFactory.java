package com.vendertool.fps.dal.job;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class JobDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class JobDAOFactorySingletonHelper {
		private static final JobDAOFactory INSTANCE = new JobDAOFactory();
	}

	private JobDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.JOB_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("jobDao");
			initialized = true;
		}
	}
	public static JobDAOFactory getInstance() {
		return JobDAOFactorySingletonHelper.INSTANCE;
	}

	public JobDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (JobDao) super.getBaseDAO();
		}
		return null;
	}
}