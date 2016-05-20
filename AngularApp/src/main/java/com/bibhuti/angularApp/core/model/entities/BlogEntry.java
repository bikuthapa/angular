package com.bibhuti.angularApp.core.model.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="blogEntry")
public class BlogEntry {

	@Id
	private String id;

	private Blog blog;
	private String title;
	private String content;
	private Date blogCreateDate;
	private BlogCategory blogCategory;
	
	
	public final String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public final String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public final Blog getBlog() {
		return this.blog;
	}

	public final void setBlog(final Blog blog) {
		this.blog = blog;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Date getBlogCreateDate() {
		return this.blogCreateDate;
	}

	public void setBlogCreateDate(final Date blogCreateDate) {
		this.blogCreateDate = blogCreateDate;
	}

	public BlogCategory getBlogCategory() {
		return this.blogCategory;
	}

	public void setBlogCategory(final BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}


	
}
