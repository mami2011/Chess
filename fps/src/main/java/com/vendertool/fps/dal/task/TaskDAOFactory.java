package com.vendertool.fps.dal.task;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class TaskDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class TaskDAOFactorySingletonHelper {
		private static final TaskDAOFactory INSTANCE = new TaskDAOFactory();
	}

	private TaskDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.TASK_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("taskDao");
			initialized = true;
		}
	}
	public static TaskDAOFactory getInstance() {
		return TaskDAOFactorySingletonHelper.INSTANCE;
	}

	public TaskDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (TaskDao) super.getBaseDAO();
		}
		return null;
	}
}