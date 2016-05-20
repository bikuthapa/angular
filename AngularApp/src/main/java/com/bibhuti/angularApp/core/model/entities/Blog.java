package com.bibhuti.angularApp.core.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="blog")
public class Blog {
    
    @Id
	private String id;
	private BlogCategory blogCategory;
	private Account owner;
	

	public final String getId() {
		return this.id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public final Account getOwner() {
		return this.owner;
	}
	public final void setOwner(final Account owner) {
		this.owner = owner;
	}
	public BlogCategory getBlogCategory() {
		return this.blogCategory;
	}
	public void setBlogCategory(final BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}
	
	
}
