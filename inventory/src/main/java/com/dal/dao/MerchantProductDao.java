package com.dal.dao;

import java.util.List;


public interface MerchantProductDao {

	void insert (MerchantProduct merchantProduct);

	void update(MerchantProduct merchantProduct);

	void delete(MerchantProduct merchantProduct);

	List<MerchantProduct> findByAccountId(long accountId);
	
	List<MerchantProduct> findByProductId(long productId);
	
}
