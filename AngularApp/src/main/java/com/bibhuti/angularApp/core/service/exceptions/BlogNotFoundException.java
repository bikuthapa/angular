package com.bibhuti.angularApp.core.service.exceptions;

public class BlogNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6895429476726287530L;

	public BlogNotFoundException() {

	}

	public BlogNotFoundException(Throwable cause) {
		super(cause);
	}

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}
	
	public BlogNotFoundException(String message){
		super(message);
	}
}
