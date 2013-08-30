/**
 * 
 */
package com.vendertool.fps.dal.job;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;
import com.vendertool.fps.dal.file.File;

/**
 * @author murali HibernateDaoSupport
 */

public class JobDaoImpl extends BaseDAO implements JobDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(Job job) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(job);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Job job) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(job);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Job job) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(job);

	}

	public List<Job> findByJobId(long jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Job> findByAccountId(long accountId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from job where account_id = :accountId");
		query.setParameter("accountId", accountId);
		query.addEntity(Job.class);
		List<Job> results = query.list();
		trans.commit();
		return results;
	}

	public List<Job> findByAccountIdAndReqFileGroupId(long accountId,
			String reqFileGroupId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from job where account_id = :accountId and request_file_group_id = :reqFileGroupId");
		query.setParameter("reqFileGroupId", reqFileGroupId);
		query.addEntity(Job.class);
		List<Job> results = query.list();
		trans.commit();
		return results;
	}

	public List<Job> findByAccountIdAndResFileGroupId(long accountId,
			String resFileGroupId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from job where account_id = :accountId and response_file_group_id = :resFileGroupId");
		query.setParameter("resFileGroupId", resFileGroupId);
		query.addEntity(Job.class);
		List<Job> results = query.list();
		trans.commit();
		return results;
	}

	

	
}