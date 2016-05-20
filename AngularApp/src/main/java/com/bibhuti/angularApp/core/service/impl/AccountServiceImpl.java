package com.bibhuti.angularApp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.repository.AccountRepository;
import com.bibhuti.angularApp.core.service.AccountService;
import com.bibhuti.angularApp.core.service.exceptions.AccountDoesNotExistException;
import com.bibhuti.angularApp.core.service.exceptions.AccountExistsException;
import com.bibhuti.angularApp.core.service.util.AccountList;
import com.bibhuti.angularApp.core.service.util.BlogList;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;


	@Override
	public Account createAccount(Account accountData) {
	Account account = accountRepository.findAccountByName(accountData.getName());
	if(account!=null){
		throw new AccountExistsException();
	}
    return	accountRepository.save(accountData);
	}

	@Override
	public Account findAccount(String id) {
		Account account = accountRepository.findAccountById(id);
		if(account!=null){
			return account;
		}else{
			throw new AccountDoesNotExistException();
		}
       
	}

	@Override
	public Blog createBlog(String accountId, Blog blogData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogList findBlogsByAccount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountList findAllAccounts() {
	return new AccountList(accountRepository.findAll());
	}

	@Override
	public Account findByAccountName(String name) {
		return accountRepository.findAccountByName(name);
	}

}
