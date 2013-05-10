package dal.dao;

import java.util.List;

import dal.dao.MlCategoryAttributeValues;

public interface MlCategoryAttributeValuesDao {

	void insert (MlCategoryAttributeValues mlCategoryAttributeValues);

	void update(MlCategoryAttributeValues mlCategoryAttributeValues);

	void delete(MlCategoryAttributeValues mlCategoryAttributeValues);

	List<MlCategoryAttributeValues> findByAttributeValueId(MlCategoryAttributeValues mlCategoryAttributeValues);
	

}
