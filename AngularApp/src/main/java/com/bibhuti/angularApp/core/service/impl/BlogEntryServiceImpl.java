package com.bibhuti.angularApp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.repository.BlogEntryRepository;
import com.bibhuti.angularApp.core.service.BlogEntryService;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;

@Service
public class BlogEntryServiceImpl implements BlogEntryService {
	
	@Autowired
	BlogEntryRepository blogEntryRepository;
	

	@Override
	public BlogEntry findBlogEntryById(String id) throws BlogNotFoundException {
		return blogEntryRepository.findOne(String.valueOf(id));
	
	}

	@Override
	public BlogEntry updateBlogEntry(String id, BlogEntry blogData) {
		BlogEntry blogEntryToUpdate = blogEntryRepository.findOne(String.valueOf(id));
		if(blogEntryToUpdate!=null){
			blogEntryRepository.save(blogData);
		}
		return null;
	}

	@Override
	public BlogEntry deleteBlogEntry(String id) {
		BlogEntry blogEntryToDelete = blogEntryRepository.findOne(String.valueOf(id));
		if(blogEntryToDelete!=null){
			 blogEntryRepository.delete(blogEntryToDelete);
	         return blogEntryToDelete;
	      }
	else{
		throw new BlogNotFoundException();
      	}
	}

}
