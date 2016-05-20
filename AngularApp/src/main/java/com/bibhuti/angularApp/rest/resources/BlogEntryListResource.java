package com.bibhuti.angularApp.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class BlogEntryListResource extends ResourceSupport{

	List<BlogEntryResource> listOfBlogEntryResource = new ArrayList<BlogEntryResource>();

	public List<BlogEntryResource> getListOfBlogEntryResource() {
		return listOfBlogEntryResource;
	}

	public void setListOfBlogEntryResource(List<BlogEntryResource> listOfBlogEntryResource) {
		this.listOfBlogEntryResource = listOfBlogEntryResource;
	}
	
	
	
	
}
