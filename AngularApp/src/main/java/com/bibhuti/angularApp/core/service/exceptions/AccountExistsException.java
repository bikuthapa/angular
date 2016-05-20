package com.bibhuti.angularApp.core.service.exceptions;

public class AccountExistsException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733400366910702679L;
	
	public AccountExistsException(){
		
	}
	public AccountExistsException(Throwable cause){
		super(cause);
	}

	public AccountExistsException(String message,Throwable cause){
		super(message,cause);
	}
	public AccountExistsException(String message){
		super(message);
	}
}
