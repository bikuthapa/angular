package com.bibhuti.angularApp.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException  extends RuntimeException{

	private static final long serialVersionUID = -4762820672623776344L;
	
	public ConflictException(){
		
	}
	public ConflictException(Throwable cause){
		super(cause);
	}

}
