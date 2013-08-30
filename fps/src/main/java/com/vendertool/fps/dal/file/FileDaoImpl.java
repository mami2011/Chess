/**
 * 
 */
package com.vendertool.fps.dal.file;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vendertool.common.dal.BaseDAO;
/**
 * @author murali HibernateDaoSupport
 */

public class FileDaoImpl extends BaseDAO implements FileDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(File file) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(file);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(File file) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.update(file);
		trans.commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(File file) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.delete(file);
		trans.commit();

	}

	public List<File> findByAccountId(long accountId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from file where account_id = :accountId");
		query.setParameter("accountId", accountId);
		query.addEntity(File.class);
		List<File> results = query.list();
		trans.commit();
		return results;
	}

	public List<File> findByAccountIdAndFileGroupId(long accountId,
			String fileGroupId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from file where account_id = :accountId and file_group_id = :fileGroupId");
		query.setParameter("accountId", accountId);
		query.setParameter("fileGroupId", fileGroupId);
		query.addEntity(File.class);
		List<File> results = query.list();
		trans.commit();
		return results;
	}

	public List<File> findByAccountIdAndFileId(long accountId, long fileId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}