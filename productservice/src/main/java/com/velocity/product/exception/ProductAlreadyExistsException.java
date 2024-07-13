package com.velocity.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ProductAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public ProductAlreadyExistsException(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}

}
