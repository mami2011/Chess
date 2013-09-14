package com.vendertool.common.dal.exception;

public class DeleteException extends Exception {
	
	private static final long serialVersionUID = -2890943422815669778L;

	public DeleteException(String message) {
        super(message);
    }
    
    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DeleteException(Throwable cause) {
        super(cause);
    }
}
