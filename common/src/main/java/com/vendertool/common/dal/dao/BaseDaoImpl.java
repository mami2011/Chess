package com.vendertool.common.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.vendertool.common.dal.exception.DBConnectionException;

public class BaseDaoImpl implements BaseDao {
	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	
	public void setDataSource(DataSource dataSource) {
		logger.debug("Datasource set to " + this.getClass().getName());
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() throws DBConnectionException {
		Connection connection = null;
		
		try {
			if(getDataSource() != null) {
				connection = getDataSource().getConnection();
			}
		} catch (SQLException e) {
			DBConnectionException se = new DBConnectionException(e);
			logger.debug(se.getMessage(), se);
			throw se;
		}
		
		if(connection == null) {
			DBConnectionException se = new DBConnectionException("Datasource is not configured");
			logger.debug(se.getMessage(), se);
			throw se;
		}
		
		return connection;
	}
}
