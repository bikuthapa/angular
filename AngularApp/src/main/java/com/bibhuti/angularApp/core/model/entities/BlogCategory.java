package com.bibhuti.angularApp.core.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="blogCategory")
public class BlogCategory {

	@Id
	private String id;
	private String category;
	private String description;
	
	public String getId() {
		return this.id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getCategory() {
		return this.category;
	}
	public void setCategory(final String category) {
		this.category = category;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	
	
	
}
