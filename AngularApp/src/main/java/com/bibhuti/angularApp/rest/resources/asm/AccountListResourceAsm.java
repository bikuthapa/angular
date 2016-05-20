package com.bibhuti.angularApp.rest.resources.asm;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bibhuti.angularApp.core.service.util.AccountList;
import com.bibhuti.angularApp.rest.mvc.AccountController;
import com.bibhuti.angularApp.rest.resources.AccountListResource;

import com.bibhuti.angularApp.rest.resources.AccountResource;
import com.bibhuti.angularApp.rest.resources.asm.AccountResourceAsm;


public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList,AccountListResource> {

	public AccountListResourceAsm(Class<AccountController> controllerClass, Class<AccountListResource> resourceType) {
		super(controllerClass, resourceType);
	
	}

	@Override
	public AccountListResource toResource(AccountList accountList) {
		
		AccountListResource accountListResource = new AccountListResource();
		 List<AccountResource> accounts = new AccountResourceAsm(AccountController.class, com.bibhuti.angularApp.rest.resources.AccountResource.class).toResources(accountList.getListOfAccounts());
		accountListResource.setListOfAccountsResource(accounts);
		return null;
	}

}
