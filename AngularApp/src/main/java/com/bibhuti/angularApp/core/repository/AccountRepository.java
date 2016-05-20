package com.bibhuti.angularApp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bibhuti.angularApp.core.model.entities.Account;

@Repository
public interface AccountRepository  extends MongoRepository <Account,String>{

@Query("{name : ?0}")
 public Account findAccountByName(String accountName);
 public Account findAccountById(String id);

}
