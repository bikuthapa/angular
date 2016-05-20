package com.bibhuti.angularApp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.bibhuti.angularApp.core.model.entities.BlogEntry;

public interface BlogEntryRepository extends MongoRepository <BlogEntry,String>{

	public BlogEntry findBlogEntryById(String id);

}
