package dal.dao;

import java.util.List;

import dal.dao.MlCategories;

public interface MlCategoryAttributesDao {

	void insert (MlCategoryAttributes mlCategoryAttributes);

	void update(MlCategoryAttributes mlCategoryAttributes);

	void delete(MlCategoryAttributes mlCategoryAttributes);

	List<MlCategoryAttributes> findByCategoryId(MlCategoryAttributes mlCategoryAttributes);
	List<MlCategoryAttributes> findByAttributeId(MlCategoryAttributes mlCategoryAttributes);
	

}
