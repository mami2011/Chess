package com.dal.dao;

import java.util.List;


public interface ShippingPolicyDao {

	void insert (ShippingPolicy shippingPolicy);

	void update(ShippingPolicy shippingPolicy);

	void delete(ShippingPolicy shippingPolicy);

	List<ShippingPolicy> findByShippingPolicyId(long shippingPolicyId);
	
	List<ShippingPolicy> findByAccountId(long accountId);
	
}
