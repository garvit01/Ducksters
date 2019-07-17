package com.atd.duckstersauthentication.exception;

public class UserAlreadyExistsException extends Exception{
private String message; 
	
	public UserAlreadyExistsException(String message) {
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
