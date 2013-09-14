package com.vendertool.common.dal.exception;

public class DBConnectionException extends Exception {

	private static final long serialVersionUID = -7366535345457518223L;

	public DBConnectionException(String message) {
        super(message);
    }
    
    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DBConnectionException(Throwable cause) {
        super(cause);
    }
}
