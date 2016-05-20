package com.bibhuti.angularApp.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.rest.mvc.AccountController;
import com.bibhuti.angularApp.rest.mvc.BlogEntryController;
import com.bibhuti.angularApp.rest.resources.AccountResource;

public class AccountResourceAsm  extends ResourceAssemblerSupport<Account,AccountResource>

{

	public AccountResourceAsm(Class<AccountController> accountcontroller, Class<AccountResource> resourceType) {
		super(accountcontroller, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AccountResource toResource(Account account) {
		AccountResource accountResource = new AccountResource();
		accountResource.setName(account.getName());
		accountResource.setPassword(account.getPassword());
		Link link = linkTo(methodOn(AccountController.class).getAccountById(account.getId())).withSelfRel();	
		accountResource.add(link);
		return accountResource;
	}

}
