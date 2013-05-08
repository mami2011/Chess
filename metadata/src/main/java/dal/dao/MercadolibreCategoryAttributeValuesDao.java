package dal.dao;

import java.util.List;

import dal.dao.MercadolibreCategoryAttributeValues;

public interface MercadolibreCategoryAttributeValuesDao {

	void insert (MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues);

	void update(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues);

	void delete(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues);

	List<MercadolibreCategoryAttributeValues> findByAttributeValueId(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues);
	

}
