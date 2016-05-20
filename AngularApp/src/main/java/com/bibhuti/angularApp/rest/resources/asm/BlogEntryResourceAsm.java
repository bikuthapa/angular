package com.bibhuti.angularApp.rest.resources.asm;


import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.rest.mvc.BlogEntryController;
import com.bibhuti.angularApp.rest.resources.BlogEntryResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

public class BlogEntryResourceAsm  extends ResourceAssemblerSupport<BlogEntry,BlogEntryResource>{

	public BlogEntryResourceAsm(Class<?> BlogEntryController, Class<BlogEntryResource> resourceType) {
		super(BlogEntryController, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource blogEntryResource= new BlogEntryResource();
		blogEntryResource.setTitle(blogEntry.getTitle());
		Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntryBasedOnId(blogEntry.getId())).withSelfRel();	
		blogEntryResource.add(link);
		return blogEntryResource;
	}

}
 