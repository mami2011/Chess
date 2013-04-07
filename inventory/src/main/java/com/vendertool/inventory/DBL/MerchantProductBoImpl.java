package com.vendertool.inventory.DBL;

public class MerchantProductBoImpl implements MerchantProductBo {
 MerchantProductDao merchantProductDao;
 
 public void setMerchantProductDao(MerchantProductDao merchantProductDao) {
		this.merchantProductDao = merchantProductDao;
	}
	public void save(MerchantProduct product) {
		// TODO Auto-generated method stub
		merchantProductDao.save(product);
	}

	public void update(MerchantProduct product) {
		// TODO Auto-generated method stub

	}

	public void delete(MerchantProduct product) {
		// TODO Auto-generated method stub

	}

	public MerchantProduct findByStockCode(MerchantProduct product) {
		// TODO Auto-generated method stub
		return null;
	}

}
