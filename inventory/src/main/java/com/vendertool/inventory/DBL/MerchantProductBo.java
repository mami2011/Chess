package com.vendertool.inventory.DBL;

public interface MerchantProductBo {

	void save(MerchantProduct product);

	void update(MerchantProduct product);

	void delete(MerchantProduct product);

	MerchantProduct findByStockCode(MerchantProduct product);
	
}
