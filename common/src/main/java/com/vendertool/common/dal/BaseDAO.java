package com.vendertool.common.dal;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport  {
	public Session getDalSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}
}