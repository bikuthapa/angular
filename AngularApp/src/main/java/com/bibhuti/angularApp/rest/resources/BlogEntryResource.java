package com.bibhuti.angularApp.rest.resources;


import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;

public class BlogEntryResource extends ResourceSupport {

	private String title;
	private String content;
	private Date blogCreateDate;
	private BlogCategory blogCategory;
	private Blog blog;

	
	
	public final String getContent() {
		return this.content;
	}

	public final void setContent(final String content) {
		this.content = content;
	}

	public final Date getBlogCreateDate() {
		return this.blogCreateDate;
	}

	public final void setBlogCreateDate(final Date blogCreateDate) {
		this.blogCreateDate = blogCreateDate;
	}

	public final BlogCategory getBlogCategory() {
		return this.blogCategory;
	}

	public final void setBlogCategory(final BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}

	public final Blog getBlog() {
		return this.blog;
	}

	public final void setBlog(final Blog blog) {
		this.blog = blog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public BlogEntry toBlogEntry(){
	BlogEntry blogEntry = new BlogEntry();
	blogEntry.setTitle(title);
	blogEntry.setContent(content);
	blogEntry.setBlog(blog);
	blogEntry.setBlogCategory(blogCategory);
	blogEntry.setBlogCreateDate(blogCreateDate);
	return blogEntry;
	
	}
}
