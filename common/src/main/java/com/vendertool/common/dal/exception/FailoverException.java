package com.vendertool.common.dal.exception;

public class FailoverException extends DatabaseException {

	private static final long serialVersionUID = -5630924008947069875L;

	public FailoverException(String message) {
        super(message);
    }
    
    public FailoverException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FailoverException(Throwable cause) {
        super(cause);
    }
}
