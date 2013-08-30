/**
 * 
 */
package com.vendertool.registration.dal.address;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali
 *HibernateDaoSupport
 */
public class AddressDaoImpl extends BaseDAO implements AddressDao {


	public void insert(Address address) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(address);
		trans.commit();
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Address address) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.update(address);
		trans.commit();

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Address address) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.delete(address);
		trans.commit();


	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Address> findByAddressId(Address address) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		String sql = "select * from address where address_id = :address_id";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("address_id", address.getAddressId());
		query.addEntity(Address.class);
		List<Address> results = query.list();
		return results;
	}
}