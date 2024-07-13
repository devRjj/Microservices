package com.velocity.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchProductExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public NoSuchProductExistsException(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
	

}

