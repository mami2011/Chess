package com.vendertool.common.dal.exception;

public class UpdateException extends Exception {
	
	private static final long serialVersionUID = -6344932538335696180L;

	public UpdateException(String message) {
        super(message);
    }
    
    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UpdateException(Throwable cause) {
        super(cause);
    }
}
