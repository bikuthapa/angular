package com.bibhuti.angularApp.core.service.exceptions;

public class BlogExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2177298325188135439L;

	public BlogExistsException() {

	}

	public BlogExistsException(Throwable cause) {
		super(cause);
	}

	public BlogExistsException(String message, Throwable cause) {
		super(message, cause);

	}

	public BlogExistsException(String message) {
		super(message);

	}
}
