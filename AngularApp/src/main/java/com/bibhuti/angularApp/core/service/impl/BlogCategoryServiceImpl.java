package com.bibhuti.angularApp.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.core.repository.BlogCategoryRepository;
import com.bibhuti.angularApp.core.service.BlogCategoryService;
import com.bibhuti.angularApp.core.service.exceptions.BlogCategoryNotFoundException;
import com.bibhuti.angularApp.core.service.util.BlogCategoryList;

@Service
@Transactional
public class BlogCategoryServiceImpl implements BlogCategoryService{

	@Autowired
	BlogCategoryRepository blogCategoryRepository;
	
	
	@Override
	public BlogCategoryList findAllBlogCategories() {
	List<BlogCategory> listOfBlogCategories = blogCategoryRepository.findAll();
	 if(!listOfBlogCategories.isEmpty()){
		 return new BlogCategoryList(listOfBlogCategories);
	 }
	 else{
		 throw new BlogCategoryNotFoundException();
	  }
	}
}
