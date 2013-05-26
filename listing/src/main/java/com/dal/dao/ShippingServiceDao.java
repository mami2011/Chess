package com.dal.dao;

import java.util.List;


public interface ShippingServiceDao {

	void insert (ShippingService shippingService);

	void update(ShippingService shippingService);

	void delete(ShippingService shippingService);

	List<ShippingService> findByShippingServiceId(long shippingServiceId);
	
	
	
}
