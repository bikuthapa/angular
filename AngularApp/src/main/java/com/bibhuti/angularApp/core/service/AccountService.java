package com.bibhuti.angularApp.core.service;


import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.service.exceptions.AccountDoesNotExistException;
import com.bibhuti.angularApp.core.service.exceptions.AccountExistsException;
import com.bibhuti.angularApp.core.service.util.AccountList;
import com.bibhuti.angularApp.core.service.util.BlogList;


public interface AccountService {
	    public Account findAccount(String id) throws AccountDoesNotExistException;
	    public Account createAccount(Account data) throws AccountExistsException;
	    public Blog createBlog(String accountId, Blog data) throws AccountDoesNotExistException;
	    public BlogList findBlogsByAccount(String accountId);
	    public AccountList findAllAccounts();
	    public Account findByAccountName(String name);
	}


