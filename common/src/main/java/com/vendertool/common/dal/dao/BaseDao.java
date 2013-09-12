package com.vendertool.common.dal.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;

public interface BaseDao {
	public static final String SELECT = "select";
	public static final String SPACE = " ";
	
	public DataSource getDataSource();
	
	public Connection getConnection() throws DBConnectionException;
	
	public boolean hasSequenceGenerator();
	
	public Long generateNextSequence(Connection connection)
			throws DBConnectionException, DatabaseException;
	
	public Long generateNextSequence() throws DBConnectionException,
				DatabaseException;
	
	public String getSequenceProcedureName();
	
	/**
	 * Call with caution, maybe only for tests
	 */
	public void cleanup();
}
