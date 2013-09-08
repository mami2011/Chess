package com.vendertool.common.dal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLDeleteClause;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;
import com.mysema.query.types.Expression;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.validation.ValidationUtil;

public abstract class BaseDaoImpl implements BaseDao {
	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	ValidationUtil VUTIL = ValidationUtil.getInstance();
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		logger.debug("Datasource set to " + this.getClass().getName());
		this.dataSource = dataSource;
	}
	
	public void finalize() {
		cleanup();
	}
	
	/**
	 * Call with caution, maybe only for tests
	 */
	@Override
	public void cleanup() {
		try {
			if(VUTIL.isNotNull(this.dataSource) && (dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource)) {
				org.apache.tomcat.jdbc.pool.DataSource ds = 
						(org.apache.tomcat.jdbc.pool.DataSource)dataSource;
				ds.close(true);
			}
		} catch (Exception e) {
			//eat it
			logger.debug(e.getMessage(), e);
		}
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
	
	public SQLDeleteClause delete(Connection connection, RelationalPath<?> path)
			throws DBConnectionException {
		SQLTemplates template = new MySQLTemplates();
		return new SQLDeleteClause(connection, template, path);
	}

	public SQLQuery from(Connection connection, Expression<?> from)
			throws DBConnectionException {
		SQLTemplates template = new MySQLTemplates();
		return new SQLQuery(connection, template).from(from);
	}

	public SQLInsertClause insert(Connection connection, RelationalPath<?> path)
			throws DBConnectionException {
		SQLTemplates template = new MySQLTemplates();
		return new SQLInsertClause(connection, template, path);
	}

	public SQLUpdateClause update(Connection connection, RelationalPath<?> path)
			throws DBConnectionException {
		SQLTemplates template = new MySQLTemplates();
		return new SQLUpdateClause(connection, template, path);
	}
	
	@Override
	public Long generateNextSequence(Connection connection) throws DBConnectionException, FinderException {
		if(!hasSequenceGenerator() || VUTIL.isNull(getSequenceProcedureName())) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(SELECT).append(SPACE).append(getSequenceProcedureName());
		String sql = sb.toString();

		try {
			ResultSet  rs = connection.prepareCall(sql).executeQuery();
			if (rs.next()){
				return new Long(rs.getLong(1));
			}
		} catch (SQLException e) {
			FinderException fe = new FinderException(
					"Unable to generate next sequence value for "
							+ getSequenceProcedureName());
			logger.debug(fe.getMessage(), fe);
			throw fe;
		}
		
		throw new FinderException(
				"Unable to generate next sequence value for "
						+ getSequenceProcedureName());
	}
}
