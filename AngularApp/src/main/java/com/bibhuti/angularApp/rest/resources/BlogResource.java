package com.bibhuti.angularApp.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;

public class BlogResource extends ResourceSupport {

	private BlogCategory blogCategory;
	private Account owner;

	public final BlogCategory getBlogCategory() {
		return this.blogCategory;
	}

	public final void setBlogCategory(final BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}
	
	public Account getOwner() {
		return owner;
	}

	public void setOwner(final Account owner) {
		this.owner = owner;
	}

	public Blog toBlog() {
		Blog blog = new Blog();
		blog.setBlogCategory(blogCategory);
		blog.setOwner(owner);
		return blog;

	}



}
