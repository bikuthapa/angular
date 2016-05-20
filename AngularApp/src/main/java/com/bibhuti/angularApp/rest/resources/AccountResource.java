package com.bibhuti.angularApp.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import com.bibhuti.angularApp.core.model.entities.Account;

public class AccountResource  extends ResourceSupport{

	private String name;
	private String password;
	
	
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public Account toAccount(){
	Account account = new Account();
	account.setName(name);
	account.setPassword(password);
    return account;
    
	}
	
}
