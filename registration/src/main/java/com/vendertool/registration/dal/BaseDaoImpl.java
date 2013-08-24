package com.vendertool.registration.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport {
	@SuppressWarnings("resource")
	static private ApplicationContext appContext;

	static {

		appContext = new ClassPathXmlApplicationContext("dal/BeanLocations.xml");
	}

	protected static ApplicationContext getAppContext() {
		if (appContext == null) {

			appContext = new ClassPathXmlApplicationContext("dal/BeanLocations.xml");
		}
		return appContext;
	}

	protected Session getDalSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}
}
