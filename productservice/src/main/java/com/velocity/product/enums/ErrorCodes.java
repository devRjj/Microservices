package com.velocity.product.enums;

public enum ErrorCodes{
	DATA_NOT_FOUND("Data nahi hai yaar", "0001"),
	DATA_ALREADY_EXISTS("Product pehle se hai yaar", "0002");
	
	private String value;
	private String code;
	
	private ErrorCodes(String value, String code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
