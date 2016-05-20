package com.bibhuti.angularApp.rest.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;




public class AccountListResource extends  ResourceSupport{

	private List<AccountResource> listOfAccountsResource;

	public List<AccountResource> getListOfAccountsResource() {
		return listOfAccountsResource;
	}

	public void setListOfAccountsResource(List<AccountResource> listOfAccountsResource) {
		this.listOfAccountsResource = listOfAccountsResource;
	}

	

	
}
