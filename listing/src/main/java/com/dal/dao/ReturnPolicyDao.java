package com.dal.dao;

import java.util.List;


public interface ReturnPolicyDao {

	void insert (ReturnPolicy returnPolicy);

	void update(ReturnPolicy returnPolicy);

	void delete(ReturnPolicy returnPolicy);

	List<ReturnPolicy> findByReturnPolicyId(long returnPolicyId);
	
	List<ReturnPolicy> findByAccountId(long accountId);
	
}
