package com.vendertool.common.dal.exception;

public class MarkdownException extends DatabaseException {
	
	private static final long serialVersionUID = -3291709382710445744L;

	public MarkdownException(String message) {
        super(message);
    }
    
    public MarkdownException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public MarkdownException(Throwable cause) {
        super(cause);
    }
}
