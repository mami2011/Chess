package com.vendertool.inventory.dal.product;

import java.util.List;


public interface ProductDao {

	void insert (Product Product);

	void update(Product Product);

	void delete(Product Product);

	List<Product> findByAccountId(long accountId);
	List<Product> findByAccountIdAndSKU(long accountId,String sku);
	
	List<Product> findByProductId(long productId);
	
}
