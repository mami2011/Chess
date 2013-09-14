package com.vendertool.common.dal.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.vendertool.common.SpringApplicationContextUtils;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;

public abstract class BaseDaoFactory {
	private static final Logger logger = Logger.getLogger(BaseDaoFactory.class);
	private Map<Class<? extends BaseDao>, BaseDaoImpl> daos = null;
	ValidationUtil VUTIL = ValidationUtil.getInstance();
	
	protected BaseDaoFactory(){
		daos = new HashMap<Class<? extends BaseDao>, BaseDaoImpl>();
		try {
			register();
		} catch (DatabaseException de) {
			throw new VTRuntimeException(de);
		}
	}
	
	protected abstract void register() throws DatabaseException;
	
	protected void add(Class<? extends BaseDao> dao, BaseDaoImpl daoimpl) {
		if(VUTIL.isNull(dao) || VUTIL.isNull(daoimpl)) {
			return;
		}
		
		daos.put(dao, daoimpl);
	}
	
	protected BaseDao getDao(Class<? extends BaseDao> dao) {
		return (BaseDao) daos.get(dao);
	}
	
	protected BaseDaoImpl getBean(String beanId) throws DatabaseException {
		if(VUTIL.isNull(beanId)) {
			DatabaseException de = new DatabaseException("Bean Id is null, cannot retrieve DAO");
			logger.debug(de.getMessage(), de);
			throw de;
		}
		
		ApplicationContext ctx = SpringApplicationContextUtils.getApplicationContext();
		Object o = ctx.getBean(beanId);
		if(VUTIL.isNull(o)) {
			DatabaseException de = new DatabaseException("Bean not registered for '" + beanId + "'");
			logger.debug(de.getMessage(), de);
			throw de;
		}
		
		return (BaseDaoImpl)o;
	}
}
