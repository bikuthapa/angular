package com.bibhuti.angularApp.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


import com.bibhuti.angularApp.core.service.util.BlogEntryList;
import com.bibhuti.angularApp.rest.mvc.BlogController;
import com.bibhuti.angularApp.rest.mvc.BlogEntryController;
import com.bibhuti.angularApp.rest.resources.BlogEntryListResource;
import com.bibhuti.angularApp.rest.resources.BlogEntryResource;


public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList,BlogEntryListResource>{

	public BlogEntryListResourceAsm(Class<BlogController> blogController, Class<BlogEntryListResource> resourceType) {
		super(blogController, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogEntryListResource toResource(BlogEntryList blogEntryList) {
         BlogEntryListResource blogEntryListResource = new BlogEntryListResource();
         blogEntryListResource.setListOfBlogEntryResource((new BlogEntryResourceAsm(BlogEntryController.class,BlogEntryResource.class).toResources(blogEntryList.getEntries())));
		
		return blogEntryListResource;
	}




}
