package com.bibhuti.angularApp.core.service.exceptions;

public class AccountDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1383956172267639255L;

	public AccountDoesNotExistException(Throwable cause) {

	}

	public AccountDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountDoesNotExistException(String message) {
		super(message);
	}

	public AccountDoesNotExistException() {

	}

}
