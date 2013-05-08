package dal.dao;

import java.util.List;

import dal.dao.MercadolibreCategories;

public interface MercadolibreCategoryAttributesDao {

	void insert (MercadolibreCategoryAttributes mercadolibreCategoryAttributes);

	void update(MercadolibreCategoryAttributes mercadolibreCategoryAttributes);

	void delete(MercadolibreCategoryAttributes mercadolibreCategoryAttributes);

	List<MercadolibreCategoryAttributes> findByCategoryId(MercadolibreCategoryAttributes mercadolibreCategoryAttributes);
	List<MercadolibreCategoryAttributes> findByAttributeId(MercadolibreCategoryAttributes mercadolibreCategoryAttributes);
	

}
