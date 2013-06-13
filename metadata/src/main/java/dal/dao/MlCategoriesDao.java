package dal.dao;

import java.util.List;

import dal.dao.MlCategories;

public interface MlCategoriesDao {

	void insert (MlCategories mlCategories);

	void update(MlCategories mlCategories);

	void delete(MlCategories mlCategories);

	List<MlCategories> findByCategoryId(MlCategories mlCategories);
	

}
