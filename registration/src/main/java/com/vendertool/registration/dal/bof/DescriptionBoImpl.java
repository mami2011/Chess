package com.vendertool.registration.dal.bof;

import com.vendertool.registration.dal.dao.DescriptionDao;

public class DescriptionBoImpl implements DescriptionBo {
 
	DescriptionDao descriptionDao;
 
 public void setAccountDao(DescriptionDao descriptionDao) {
		this.descriptionDao = descriptionDao;
	}
	public void insert(Description description) {
		// TODO Auto-generated method stub
		descriptionDao.insert(description);
	}

	public void update(Description description) {
		// TODO Auto-generated method stub

	}

	public void delete(Description description) {
		// TODO Auto-generated method stub

	}

	public Description findByStockCode(Description description) {
		// TODO Auto-generated method stub
		descriptionDao.findByStockCode(description);
		return null;
	}

}
