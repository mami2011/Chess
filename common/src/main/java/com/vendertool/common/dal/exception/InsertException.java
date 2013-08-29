package com.vendertool.common.dal.exception;

public class InsertException extends DatabaseException {
	
	private static final long serialVersionUID = -5359266794440692878L;

	public InsertException(String message) {
        super(message);
    }
    
    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InsertException(Throwable cause) {
        super(cause);
    }
}
