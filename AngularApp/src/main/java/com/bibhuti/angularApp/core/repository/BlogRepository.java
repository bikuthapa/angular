package com.bibhuti.angularApp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.bibhuti.angularApp.core.model.entities.Blog;

public interface BlogRepository extends MongoRepository <Blog,String>{
public Blog findBlogById(String id);
}
