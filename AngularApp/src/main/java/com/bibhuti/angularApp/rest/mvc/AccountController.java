package com.bibhuti.angularApp.rest.mvc;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.service.AccountService;
import com.bibhuti.angularApp.core.service.exceptions.AccountDoesNotExistException;
import com.bibhuti.angularApp.core.service.exceptions.AccountExistsException;
import com.bibhuti.angularApp.core.service.exceptions.BlogExistsException;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;
import com.bibhuti.angularApp.core.service.util.AccountList;
import com.bibhuti.angularApp.core.service.util.BlogList;
import com.bibhuti.angularApp.rest.exceptions.BadRequestException;
import com.bibhuti.angularApp.rest.exceptions.ConflictException;
import com.bibhuti.angularApp.rest.resources.AccountListResource;
import com.bibhuti.angularApp.rest.resources.AccountResource;
import com.bibhuti.angularApp.rest.resources.BlogListResource;
import com.bibhuti.angularApp.rest.resources.BlogResource;
import com.bibhuti.angularApp.rest.resources.asm.AccountListResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.AccountResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogListResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogResourceAsm;

import com.bibhuti.angularApp.rest.exceptions.NotFoundException;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	// create account
	@RequestMapping(value = "/rest/accounts", method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource accountData) {
		try {
			Account account = accountService.createAccount(accountData.toAccount());
			AccountResource accountResource = new AccountResourceAsm(AccountController.class, AccountResource.class)
					.toResource(account);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(accountResource.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(accountResource, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			 throw new ConflictException(exception);
		}

	}

	// get account by id
	@RequestMapping(value = "/rest/accounts/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountResource> getAccountById(@PathVariable String accountId) {
		Account account = accountService.findAccount(accountId);
		if (account != null) {
			AccountResource accountResource = new AccountResourceAsm(AccountController.class, AccountResource.class)
					.toResource(account);
			return new ResponseEntity<AccountResource>(accountResource, HttpStatus.OK);
		} else {
			 return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		}

	}

	// find all accounts
	 @RequestMapping(value="/rest/accounts/", method=RequestMethod.GET)
	 public ResponseEntity<AccountListResource> findAllAccounts(){
	
		 try{
			 AccountList accountList = accountService.findAllAccounts();
			 AccountListResource accountListResource = new AccountListResourceAsm(AccountController.class,AccountListResource.class).toResource(accountList);
			 return new ResponseEntity<AccountListResource>(accountListResource,HttpStatus.OK);
		 }
		 catch(AccountDoesNotExistException e){
			 throw new NotFoundException(e);
		 }
		
	 }

	// create blogs
	@RequestMapping(value = "/rest/accounts/{accountId}/blogs", method = RequestMethod.POST)
	public ResponseEntity<BlogResource> createBlog(@PathVariable String accountId, @RequestBody BlogResource blogData) {

		try {
			Blog blog = accountService.createBlog(accountId, blogData.toBlog());
			BlogResource blogResource = new BlogResourceAsm(BlogController.class, BlogResource.class).toResource(blog);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(blogResource.getLink("self").getHref()));
			return new ResponseEntity<BlogResource>(blogResource, HttpStatus.CREATED);

		}  catch(AccountDoesNotExistException exception)
        {
            throw new NotFoundException(exception);
        } catch(BlogExistsException exception)
        {
            throw new ConflictException(exception);
        }

	}

	// find all blogs
	@RequestMapping(value="/rest/accounts/{accountId}/blogs", method = RequestMethod.GET)
	public ResponseEntity<BlogListResource> getListOfBlogs(@PathVariable String accountId){
		try{
		BlogList listOfBlogs = accountService.findBlogsByAccount(accountId);
		BlogListResource blogListResource = new BlogListResourceAsm(BlogController.class, BlogListResource.class).toResource(listOfBlogs);
		return new ResponseEntity<BlogListResource>(blogListResource,HttpStatus.OK);
	      }
		catch(AccountDoesNotExistException e){
			throw new NotFoundException();
		  }
			
		}
}
