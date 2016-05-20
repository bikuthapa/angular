package com.bibhuti.angularApp.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.rest.mvc.BlogController;
import com.bibhuti.angularApp.rest.resources.BlogCategoryResource;

public class BlogCategoryResourceAsm extends ResourceAssemblerSupport<BlogCategory,BlogCategoryResource>{

	public BlogCategoryResourceAsm(Class<BlogController> controllerClass, Class<BlogCategoryResource> resourceType) {
		super(controllerClass, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogCategoryResource toResource(BlogCategory blogCategory) {
		BlogCategoryResource blogCategoryResource = new BlogCategoryResource();
		blogCategoryResource.setCategory(blogCategory.getCategory());
		blogCategoryResource.setDescription(blogCategory.getDescription());
		return blogCategoryResource;
	}

}
