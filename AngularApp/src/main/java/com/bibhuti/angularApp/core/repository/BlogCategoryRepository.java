package com.bibhuti.angularApp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;

public interface BlogCategoryRepository extends MongoRepository <BlogCategory,String>{ 

}
