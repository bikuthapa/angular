package com.bibhuti.angularApp.rest.resources.asm;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


import com.bibhuti.angularApp.core.service.util.BlogCategoryList;
import com.bibhuti.angularApp.rest.mvc.BlogController;
import com.bibhuti.angularApp.rest.resources.BlogCategoryListResource;
import com.bibhuti.angularApp.rest.resources.BlogCategoryResource;

public class BlogCategoryListResourceAsm  extends ResourceAssemblerSupport<BlogCategoryList,BlogCategoryListResource>{

	public BlogCategoryListResourceAsm(Class<BlogController> controllerClass, Class<BlogCategoryListResource> resourceType) {
		super(controllerClass, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlogCategoryListResource toResource(BlogCategoryList blogCategoryList) {
		BlogCategoryListResource blogCategoryListResource = new BlogCategoryListResource();
		List<BlogCategoryResource> blogCatagoryResources = new BlogCategoryResourceAsm(BlogController.class,BlogCategoryResource.class).toResources(blogCategoryList.getListOfBlogCategories());
		blogCategoryListResource.setBlogCategoryListResource(blogCatagoryResources);
		return blogCategoryListResource;
	}

}
