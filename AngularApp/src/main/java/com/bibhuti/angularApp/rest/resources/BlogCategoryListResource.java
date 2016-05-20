package com.bibhuti.angularApp.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class BlogCategoryListResource extends  ResourceSupport{

	private List<BlogCategoryResource> blogCategoryListResource =new ArrayList<BlogCategoryResource>();

	public List<BlogCategoryResource> getBlogCategoryListResource() {
		return blogCategoryListResource;
	}

	public void setBlogCategoryListResource(List<BlogCategoryResource> blogCategoryListResource) {
		this.blogCategoryListResource = blogCategoryListResource;
	}
}
