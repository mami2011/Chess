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

	public AddressDaoImpl() {
		super();
		init(null);
	}

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
		// TODO Auto-generated method stub
		getHibernateTemplate().update(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Address> findByAddressId(Address address) {
		// TODO Auto-generated method stub
		String sql = "select * from address where address_id = :address_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("address_id", address.getAddressId());
		query.addEntity(Address.class);
		List<Address> results = query.list();
		return results;
	}
}