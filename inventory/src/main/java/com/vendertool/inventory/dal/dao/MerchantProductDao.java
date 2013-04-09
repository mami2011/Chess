package com.vendertool.inventory.dal.dao;

import com.vendertool.inventory.dal.bof.MerchantProduct;

public interface MerchantProductDao {

	void save(MerchantProduct product);

	void update(MerchantProduct product);

	void delete(MerchantProduct product);

	MerchantProduct findByStockCode(MerchantProduct product);
	
}
