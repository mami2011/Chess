package com.vendertool.registration.dal.bof;

public interface AccountBo {

	void insert(Account account);

	void update(Account account);

	void delete(Account account);

	Address findByStockCode(Account account);
	
}
