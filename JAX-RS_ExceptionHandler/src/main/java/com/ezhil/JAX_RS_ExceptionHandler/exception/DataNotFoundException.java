package com.ezhil.JAX_RS_ExceptionHandler.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 844101068544308045L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
