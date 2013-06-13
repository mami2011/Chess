package dal.dao;

import java.util.List;

import dal.dao.MlCategories;

public interface MlCategoriesDumpDateDao {

	void insert (MlCategoriesDumpDate mlCategoriesDumpDate);

	void update(MlCategoriesDumpDate mlCategoriesDumpDate);

	void delete(MlCategoriesDumpDate mlCategoriesDumpDate);

	List<MlCategoriesDumpDate> findBySiteId(MlCategoriesDumpDate mlCategoriesDumpDate);
	

}
