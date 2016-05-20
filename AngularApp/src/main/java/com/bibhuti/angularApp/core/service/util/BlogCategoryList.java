package com.bibhuti.angularApp.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.bibhuti.angularApp.core.model.entities.BlogCategory;

public class BlogCategoryList {

	private List<BlogCategory> listOfBlogCategories= new ArrayList<BlogCategory>();

	public BlogCategoryList(List<BlogCategory> entries) {
		this.listOfBlogCategories= entries;
	}

	public List<BlogCategory> getListOfBlogCategories() {
		return this.listOfBlogCategories;
	}

	public void setListOfBlogCategories(final List<BlogCategory> listOfBlogCategories) {
		this.listOfBlogCategories = listOfBlogCategories;
	}
}
