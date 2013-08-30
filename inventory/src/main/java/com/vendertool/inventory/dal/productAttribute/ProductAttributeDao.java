package com.vendertool.inventory.dal.productAttribute;

import java.util.List;


public interface ProductAttributeDao {

	void insert (ProductAttribute productAttribute);

	void update(ProductAttribute productAttribute);

	void delete(ProductAttribute productAttribute);

	//List<ProductAttribute> findByProductAttributeId(long accountId);
	
}
