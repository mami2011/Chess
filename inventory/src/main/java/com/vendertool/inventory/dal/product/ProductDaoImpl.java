/**
 * 
 */
package com.vendertool.inventory.dal.product;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali HibernateDaoSupport
 */

public class ProductDaoImpl extends BaseDAO implements ProductDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.ProductDao#save(com.vendertool
	 * .inventory.DBL.BO.Product)
	 */
	public void insert(Product product) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.ProductDao#update(com.vendertool
	 * .inventory.DBL.BO.Product)
	 */
	public void update(Product product) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(product);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.ProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.Product)
	 */
	public void delete(Product product) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(product);

	}


		public List<Product> findByAccountId(long accountId) {
			// TODO Auto-generated method stub
			String sql = "select * from _product where account_id = :account_id";
			SQLQuery query=getSession().createSQLQuery(sql);
			query.setParameter("account_id", accountId);
			query.addEntity(Product.class);
			List<Product> results = query.list();
			return  results;
		}

		public List<Product> findByProductId(long productId) {
			// TODO Auto-generated method stub
			String sql = "select * from _product where product_id = :product_id";
			SQLQuery query=getSession().createSQLQuery(sql);
			query.setParameter("product_id", productId);
			query.addEntity(Product.class);
			List<Product> results = query.list();
			return  results;
		}

		public List<Product> findByAccountIdAndSKU(long accountId,
				String sku) {
			String sql = "select * from _product where account_id = :account_id and sku = :sku";
			SQLQuery query=getSession().createSQLQuery(sql);
			query.setParameter("account_id", accountId);
			query.setParameter("sku", sku);
			query.addEntity(Product.class);
			List<Product> results = query.list();
			return  results;
		}

	
}