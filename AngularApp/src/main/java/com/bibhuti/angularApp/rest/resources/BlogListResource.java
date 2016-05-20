package com.bibhuti.angularApp.rest.resources;

import java.util.List;
import java.util.ArrayList;

import org.springframework.hateoas.ResourceSupport;

public class BlogListResource extends ResourceSupport{

	private List<BlogResource> blogs = new ArrayList<BlogResource>();

	public List<BlogResource> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogResource> blogs) {
		this.blogs = blogs;
	}
	
	
	
}
