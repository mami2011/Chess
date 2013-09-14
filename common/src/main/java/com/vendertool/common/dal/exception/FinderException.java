package com.vendertool.common.dal.exception;

public class FinderException extends Exception {
	
	private static final long serialVersionUID = -3869385456229055089L;

	public FinderException(String message) {
        super(message);
    }
    
    public FinderException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FinderException(Throwable cause) {
        super(cause);
    }
}
