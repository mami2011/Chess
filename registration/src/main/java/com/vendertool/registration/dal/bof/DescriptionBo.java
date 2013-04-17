package com.vendertool.registration.dal.bof;

public interface DescriptionBo {

	void insert(Description description);

	void update(Description description);

	void delete(Description description);

	Description findByStockCode(Description description);
	
}
