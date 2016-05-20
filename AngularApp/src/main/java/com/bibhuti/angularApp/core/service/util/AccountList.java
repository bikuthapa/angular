package com.bibhuti.angularApp.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.bibhuti.angularApp.core.model.entities.Account;

public class AccountList {

	private List<Account> listOfAccounts = new ArrayList<Account>();

	public AccountList(List<Account> accountList){
		this.listOfAccounts=accountList;
	}
	
	public List<Account> getListOfAccounts() {
		return this.listOfAccounts;
	}

	public void setListOfAccounts(final List<Account> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}
	
}
