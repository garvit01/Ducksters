package com.atd.duckstersService.exception;

@SuppressWarnings("serial")
public class InvalidParameter extends Exception {
	String message;

	public InvalidParameter(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
