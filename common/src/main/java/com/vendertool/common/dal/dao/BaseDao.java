package com.vendertool.common.dal.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import com.vendertool.common.dal.exception.DBConnectionException;

public interface BaseDao {
	public DataSource getDataSource();
	
	public Connection getConnection() throws DBConnectionException;
}
