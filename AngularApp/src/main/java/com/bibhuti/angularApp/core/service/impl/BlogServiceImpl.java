package com.bibhuti.angularApp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.repository.BlogEntryRepository;
import com.bibhuti.angularApp.core.repository.BlogRepository;
import com.bibhuti.angularApp.core.service.BlogService;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;
import com.bibhuti.angularApp.core.service.util.BlogEntryList;
import com.bibhuti.angularApp.core.service.util.BlogList;


@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	BlogEntryRepository blogEntryRepository;

	@Override
	public BlogEntryList findAllBlogEntries(String id) {
		Blog blog = blogRepository.findOne(String.valueOf(id));
		if(blog != null){
			return new BlogEntryList(blogEntryRepository.findAll());
		}else{
			throw new BlogNotFoundException();
		}
		
	}

	@Override
	public Blog findBlog(String blogId) {
	Blog blog = blogRepository.findOne(String.valueOf(blogId));
		return blog;
	}

	@Override
	public BlogEntry createBlogEntry(String blogId, BlogEntry data) {
		Blog blog = blogRepository.findOne(String.valueOf(blogId));
		if(blog!=null){
			throw new BlogNotFoundException();
		}
		BlogEntry blogEntry = blogEntryRepository.save(data);
		return 	blogEntry;
		
	}

	@Override
	public BlogList findAllBlogs() {
		return new BlogList(blogRepository.findAll());
			}

	@Override
	public Blog createBlog(Blog blog) {
	Blog savedBlog =  blogRepository.save(blog);
	return savedBlog;
	}

}
