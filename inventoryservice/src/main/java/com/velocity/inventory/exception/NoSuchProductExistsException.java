package com.velocity.inventory.exception;

public class NoSuchProductExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSuchProductExistsException(String msg) {
		super(msg);
	}
	

}
