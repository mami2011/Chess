/**
 * 
 */
package com.vendertool.fps.dal.task;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;
import com.vendertool.fps.dal.job.Job;

/**
 * @author murali HibernateDaoSupport
 */

public class TaskDaoImpl extends BaseDAO implements TaskDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(Task task) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(task);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Task task) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.update(task);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Task task) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.delete(task);
		trans.commit();
	}

	
	public List<Task> findByJobId(long jobId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from task where job_id = :jobId");
		query.setParameter("jobId", jobId);
		query.addEntity(Task.class);
		List<Task> results = query.list();
		trans.commit();
		return results;
	}

	public List<Task> findByTaskId(long taskId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from task where task_id = :taskId");
		query.setParameter("taskId", taskId);
		query.addEntity(Task.class);
		List<Task> results = query.list();
		trans.commit();
		return results;
	}

	
}