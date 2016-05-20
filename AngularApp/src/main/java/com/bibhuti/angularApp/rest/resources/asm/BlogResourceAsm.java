package com.bibhuti.angularApp.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.rest.mvc.BlogController;
import com.bibhuti.angularApp.rest.mvc.BlogEntryController;
import com.bibhuti.angularApp.rest.resources.BlogResource;

public class BlogResourceAsm  extends  ResourceAssemblerSupport<Blog,BlogResource>{

	public BlogResourceAsm(Class<BlogController> blogController, Class<BlogResource> resourceType) {
		super(blogController, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogResource toResource(Blog blog) {
		BlogResource blogResource = new BlogResource();
		blogResource.setBlogCategory(blog.getBlogCategory());
		Link link = linkTo(methodOn(BlogController.class).findBlogById(blog.getId())).withSelfRel();
		blogResource.add(link);
		return blogResource;
	}

}
