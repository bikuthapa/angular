package com.bibhuti.angularApp.core.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bibhuti.angularApp.core.model.entities.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringMongoConfigurationTest.xml")
public class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void addingAccountNonExistingAccount(){
		Account account = new Account();
		account.setId("2");
		account.setName("Bibhuti2");
		account.setPassword("test1");
	    account =accountRepository.save(account);
	    assertNotNull(account.getName());
		
	}
	@Test
	public void findAccountById(){
		Account account = accountRepository.findAccountById("2");
		assertNotNull(account.getName());
		
	}
	
	@Test
	public void findAccountByName(){
	Account accountAfterFetch = accountRepository.findAccountByName("Bibhuti2");
	assertNotNull(accountAfterFetch.getName());
	}

}
