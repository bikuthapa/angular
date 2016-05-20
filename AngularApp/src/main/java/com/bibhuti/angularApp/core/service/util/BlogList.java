package com.bibhuti.angularApp.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.bibhuti.angularApp.core.model.entities.Blog;

public class BlogList {

	private List<Blog> blogs = new ArrayList<Blog>();

	public BlogList(List<Blog> resultList) {
		this.blogs= resultList;
	}

	public final List<Blog> getBlogs() {
		return this.blogs;
	}

	public final void setBlogs(final List<Blog> blogs) {
		this.blogs = blogs;
	}
	
	
}
