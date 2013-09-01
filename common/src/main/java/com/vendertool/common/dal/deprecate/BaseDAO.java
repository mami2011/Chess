package com.vendertool.common.dal.deprecate;

import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.ContextLoader;

import com.vendertool.common.validation.ValidationUtil;

public class BaseDAO extends HibernateDaoSupport  {
	static ValidationUtil vutil = ValidationUtil.getInstance();
	private static final String QUERY_SEPARATOR = ",";
	private static final String UPDATE = "update";
	private static final String WHERE = "where";
	private static final String SET = "set";
	private static final String SPACE = " ";
	private static final String EQUALS = "=";
	private static final String COLON = ":";
	private static final String SET_PROP_PREFIX = "s_";
	private static final String WHERE_PROP_PREFIX = "w_";
	
	
	private BaseDAO dao; 
	
	public void init(String beanIds) {
		if (beanIds == null) {
			ApplicationContext ctx = ContextLoader
					.getCurrentWebApplicationContext();
			dao = (BaseDAO) ctx.getBean(beanIds);
		}
	}
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}


	public Session getDalSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}
	
	public String getDatabaseColumnName(
			@SuppressWarnings("rawtypes") Class clazz, String propertyName) {
		if(vutil.isNull(clazz) || (vutil.isEmpty(propertyName))) {
			return null;
		}
		
		try {
			ClassMetadata cmd = dao.getSessionFactory().getClassMetadata(clazz);
			String[] propertyNames = ((AbstractEntityPersister)cmd).getPropertyColumnNames(propertyName);
			if(vutil.isNull(propertyNames)) {
				return null;
			}
			
			return propertyNames[0];
		} catch (Exception ex) {
			logger.debug(ex.getMessage(), ex);
			return null;
		}
	}
	
	public String getDatabaseTableName(@SuppressWarnings("rawtypes") Class clazz) {
		if(vutil.isNull(clazz)) {
			return null;
		}
		
		try {
			ClassMetadata cmd = dao.getSessionFactory().getClassMetadata(clazz);
			String tablename = ((AbstractEntityPersister)cmd).getTableName();
			return tablename;
		} catch (Exception ex) {
			logger.debug(ex.getMessage(), ex);
			return null;
		}
	}
	
	public String generateSelectQueryFieldString(
			@SuppressWarnings("rawtypes") Class clazz, String... propertyNames) {
		if(vutil.isNull(clazz) || (vutil.isNull(propertyNames))) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		for(String propname : propertyNames) {
			String colname = getDatabaseColumnName(clazz, propname);
			if(!vutil.isEmpty(colname)) {
				sb.append(colname);
				sb.append(QUERY_SEPARATOR).append(SPACE);
			}
		}
		
		String qryStr = cleanQueryFieldString(sb);
		
		return qryStr;
	}
	
	public String generateUpdateQueryFieldString(
			@SuppressWarnings("rawtypes") Class clazz, String propPrefix,
			String... propertyNames) {
		if(vutil.isNull(clazz) || (vutil.isNull(propertyNames))) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		for(String propname : propertyNames) {
			String colname = getDatabaseColumnName(clazz, propname);
			if(!vutil.isEmpty(colname)) {
				sb.append(colname).append(SPACE).append(EQUALS).append(SPACE);
				sb.append(COLON).append(propPrefix).append(propname);
				sb.append(QUERY_SEPARATOR).append(SPACE);
			}
		}
		
		String qryStr = cleanQueryFieldString(sb);
		
		return qryStr;
	}

	private String cleanQueryFieldString(StringBuffer sb) {
		String qryStr = sb.toString().trim();
		
		if(qryStr.charAt(qryStr.length()-1) == ',') {
			qryStr = qryStr.substring(0, qryStr.length()-1);
		}
		return qryStr;
	}
	
	public SQLQuery getUpdateQuery(@SuppressWarnings("rawtypes") Class clazz,
			Map<String, Object> setPropertyValueMap,
			Map<String, Object> wherePropertyValueMap) {
		
		if(vutil.isNull(clazz) || (vutil.isNull(setPropertyValueMap))) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(UPDATE)
			.append(SPACE)
			.append(getDatabaseTableName(clazz))
			.append(SPACE)
			.append(SET)
			.append(SPACE);
		
			Set<String> keys = setPropertyValueMap.keySet();
			String[] propnames = (String[])keys.toArray();
			sb.append(generateUpdateQueryFieldString(clazz, SET_PROP_PREFIX, propnames));
			
			sb.append(SPACE).append(WHERE).append(SPACE);
			
			Set<String> wkeys = wherePropertyValueMap.keySet();
			String[] wpropnames = (String[])wkeys.toArray();
			sb.append(generateUpdateQueryFieldString(clazz, WHERE_PROP_PREFIX, wpropnames));
			
			String sql = sb.toString().trim();
			SQLQuery query = getSession().createSQLQuery(sql);
			query.addEntity(clazz);
			
			for(String propName : keys) {
				Object value = setPropertyValueMap.get(propName);
				query.setParameter(SET_PROP_PREFIX + propName, value);
			}
			
			for(String propName : wkeys) {
				Object value = wherePropertyValueMap.get(propName);
				query.setParameter(WHERE_PROP_PREFIX + propName, value);
			}
			
			return query;
	}
}