package com.vendertool.inventory.dal.bof;

public interface MerchantProductBo {

	void save(MerchantProduct product);

	void update(MerchantProduct product);

	void delete(MerchantProduct product);

	MerchantProduct findByStockCode(MerchantProduct product);
	
}
