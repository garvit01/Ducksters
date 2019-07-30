package com.atd.duckstersService.exception;

@SuppressWarnings("serial")
public class AlreadyFoundException extends Exception {

	private String message;

	public AlreadyFoundException(String message) {
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
