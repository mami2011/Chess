package com.vendertool.common.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.vendertool.common.dal.deprecate.BaseDAO;
import com.vendertool.common.validation.ValidationUtil;

public abstract class BaseDAOFactory {

	protected BaseDAO dao;

	protected BaseDAO getBaseDAO() {
		return dao;
	}

	protected void initDAOBean(String beanId) {
		if (!ValidationUtil.getInstance().isEmpty(beanId)) {
			ApplicationContext ctx = ContextLoader
					.getCurrentWebApplicationContext();
			dao = (BaseDAO) ctx.getBean(beanId);
		}
	}
}