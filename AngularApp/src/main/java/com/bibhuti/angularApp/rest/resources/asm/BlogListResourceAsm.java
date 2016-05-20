package com.bibhuti.angularApp.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.bibhuti.angularApp.core.service.util.BlogList;
import com.bibhuti.angularApp.rest.mvc.BlogController;
import com.bibhuti.angularApp.rest.resources.BlogListResource;
import com.bibhuti.angularApp.rest.resources.BlogResource;

public class BlogListResourceAsm  extends  ResourceAssemblerSupport<BlogList,BlogListResource>{

	public BlogListResourceAsm(Class<BlogController> blogController, Class<BlogListResource> resourceType) {
		super(blogController, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogListResource toResource(BlogList blogList) {
		BlogListResource blogListResource = new BlogListResource();
		blogListResource.setBlogs((new BlogResourceAsm(BlogController.class, BlogResource.class).toResources(blogList.getBlogs())));
		return blogListResource;
		
	}

}
