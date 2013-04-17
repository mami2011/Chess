package com.vendertool.registration.dal.dao;

import com.vendertool.registration.dal.bof.Description;

public interface DescriptionDao {

	void insert (Description description);

	void update(Description description);

	void delete(Description description);

	Description findByStockCode(Description description);
	
}
