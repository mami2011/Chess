package com.dal.dao;

import java.util.List;


public interface ImageDao {

	void insert (Image image);

	void update(Image image);

	void delete(Image image);

	List<Image> findByAccountId(long accountId);
	
}
