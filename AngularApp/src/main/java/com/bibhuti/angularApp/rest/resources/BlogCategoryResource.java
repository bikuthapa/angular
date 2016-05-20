package com.bibhuti.angularApp.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import com.bibhuti.angularApp.core.model.entities.BlogCategory;

public class BlogCategoryResource extends ResourceSupport{

	private String category;
	private String description;
	
	public final String getCategory() {
		return this.category;
	}
	public final void setCategory(String category) {
		this.category = category;
	}
	public final String getDescription() {
		return this.description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	
	public BlogCategory toBlogCategory(){
		BlogCategory blogCategory = new BlogCategory();
		blogCategory.setCategory(this.category);
		blogCategory.setDescription(this.description);
		return blogCategory;
	}
}
