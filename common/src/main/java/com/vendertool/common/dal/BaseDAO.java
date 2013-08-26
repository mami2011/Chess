package com.vendertool.common.dal;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.ContextLoader;

public class BaseDAO extends HibernateDaoSupport  {
	
	private BaseDAO dao; 
	
	public void init(String beanIds) {
		if (beanIds == null) {
			ApplicationContext ctx = ContextLoader
					.getCurrentWebApplicationContext();
			dao = (BaseDAO) ctx.getBean(beanIds);
		}
	}
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}


	public Session getDalSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}
}