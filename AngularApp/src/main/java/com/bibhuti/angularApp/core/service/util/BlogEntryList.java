package com.bibhuti.angularApp.core.service.util;


import java.util.ArrayList;
import java.util.List;

import com.bibhuti.angularApp.core.model.entities.BlogEntry;

public class BlogEntryList {

	private List<BlogEntry> entries= new ArrayList<BlogEntry>();
	private Long blogId;
	
	
	public BlogEntryList(List<BlogEntry> resultEntries) {
		this.entries=resultEntries;
	}
	public BlogEntryList() {
		// TODO Auto-generated constructor stub
	}
	public final List<BlogEntry> getEntries() {
		return this.entries;
	}
	public final void setEntries(final List<BlogEntry> entries) {
		this.entries = entries;
	}
	public final Long getBlogId() {
		return this.blogId;
	}
	public final void setBlogId(final Long blogId) {
		this.blogId = blogId;
	}
	
}
