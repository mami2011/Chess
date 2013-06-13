package com.dal.dao;

import java.util.List;


public interface ProductClassificationDao {

	void insert (ProductClassification productClassification);

	void update(ProductClassification productClassification);

	void delete(ProductClassification productClassification);

	List<ProductClassification> findByClassificationId(long classificationId);
	
	
	
}
