package com.bibhuti.angularApp.core.service.exceptions;

public class BlogCategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3903279527637022045L;

	public BlogCategoryNotFoundException() {

	}

	public BlogCategoryNotFoundException(Throwable cause) {
		super(cause);
	}

	public BlogCategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}
	
	public BlogCategoryNotFoundException(String message){
		super(message);
	}
}
