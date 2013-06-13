package com.dal.dao;

import java.util.List;


public interface ProductDescriptionDao {

	void insert (ProductDescription productDescription);

	void update(ProductDescription productDescription);

	void delete(ProductDescription productDescription);

	List<ProductDescription> findByProductId(long productId);
	
}
