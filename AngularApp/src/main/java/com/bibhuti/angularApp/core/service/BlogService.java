package com.bibhuti.angularApp.core.service;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.util.BlogEntryList;
import com.bibhuti.angularApp.core.service.util.BlogList;



public interface BlogService {

	public BlogEntryList findAllBlogEntries(String id);
	
	public Blog findBlog(String id);
	
	public Blog createBlog(Blog blog);
	
	public BlogEntry createBlogEntry(String blogId, BlogEntry data);

    public BlogList findAllBlogs();
   
}
