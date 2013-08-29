package com.vendertool.common.dal.exception;

public class QuerySyntaxException extends DatabaseException {
	
	private static final long serialVersionUID = -1154151698528705660L;

	public QuerySyntaxException(String message) {
        super(message);
    }
    
    public QuerySyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public QuerySyntaxException(Throwable cause) {
        super(cause);
    }
}
