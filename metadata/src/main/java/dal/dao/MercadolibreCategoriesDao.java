package dal.dao;

import java.util.List;

import dal.dao.MercadolibreCategories;

public interface MercadolibreCategoriesDao {

	void insert (MercadolibreCategories mercadolibreCategories);

	void update(MercadolibreCategories mercadolibreCategories);

	void delete(MercadolibreCategories mercadolibreCategories);

	List<MercadolibreCategories> findByCategoryId(MercadolibreCategories mercadolibreCategories);
	

}
