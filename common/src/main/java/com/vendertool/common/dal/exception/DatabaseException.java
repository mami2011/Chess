package com.vendertool.common.dal.exception;

/**
 * Base exception for vender tool representing all DAL exception
 *
 */
public class DatabaseException extends Exception {
	private static final long serialVersionUID = 8344315408521069744L;

	public DatabaseException(String message) {
        super(message);
    }
    
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
