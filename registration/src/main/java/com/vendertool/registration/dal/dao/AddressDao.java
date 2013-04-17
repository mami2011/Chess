package com.vendertool.registration.dal.dao;

import com.vendertool.registration.dal.bof.Address;

public interface AddressDao {

	void insert (Address account);

	void update(Address account);

	void delete(Address account);

	Address findByStockCode(Address account);
	
}
