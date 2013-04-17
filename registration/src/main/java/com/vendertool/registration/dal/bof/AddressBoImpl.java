package com.vendertool.registration.dal.bof;

import com.vendertool.registration.dal.dao.AddressDao;

public class AddressBoImpl implements AddressBo {
 
	AddressDao addressDao;
 
 public void setAccountDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	public void insert(Address address) {
		// TODO Auto-generated method stub
		addressDao.insert(address);
	}

	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	public void delete(Address address) {
		// TODO Auto-generated method stub

	}

	public Address findByStockCode(Address address) {
		// TODO Auto-generated method stub
		addressDao.findByStockCode(address);
		return null;
	}

}
