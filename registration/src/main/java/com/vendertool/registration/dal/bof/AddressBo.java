package com.vendertool.registration.dal.bof;

public interface AddressBo {

	void insert(Address account);

	void update(Address account);

	void delete(Address account);

	Address findByStockCode(Address account);
	
}
