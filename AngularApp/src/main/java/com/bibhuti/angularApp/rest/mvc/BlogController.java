package com.bibhuti.angularApp.rest.mvc;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.BlogCategoryService;
import com.bibhuti.angularApp.core.service.BlogService;
import com.bibhuti.angularApp.core.service.exceptions.BlogCategoryNotFoundException;
import com.bibhuti.angularApp.core.service.exceptions.BlogExistsException;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;
import com.bibhuti.angularApp.core.service.util.BlogCategoryList;
import com.bibhuti.angularApp.core.service.util.BlogEntryList;
import com.bibhuti.angularApp.core.service.util.BlogList;
import com.bibhuti.angularApp.rest.exceptions.ConflictException;
import com.bibhuti.angularApp.rest.exceptions.NotFoundException;
import com.bibhuti.angularApp.rest.resources.BlogCategoryListResource;
import com.bibhuti.angularApp.rest.resources.BlogEntryListResource;
import com.bibhuti.angularApp.rest.resources.BlogEntryResource;
import com.bibhuti.angularApp.rest.resources.BlogListResource;
import com.bibhuti.angularApp.rest.resources.BlogResource;
import com.bibhuti.angularApp.rest.resources.asm.BlogCategoryListResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogEntryListResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogEntryResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogListResourceAsm;
import com.bibhuti.angularApp.rest.resources.asm.BlogResourceAsm;

@Controller
@RequestMapping("/rest/blogs")
public class BlogController {

	@Autowired
	BlogService blogService;

	@Autowired
	BlogCategoryService blogCategoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<BlogListResource> findAllBlogs() {
		BlogList listOfBlogs = blogService.findAllBlogs();
		BlogListResource blogListResource = new BlogListResourceAsm(BlogController.class, BlogListResource.class)
				.toResource(listOfBlogs);
		return new ResponseEntity<BlogListResource>(blogListResource, HttpStatus.OK);
	}
	

	//create a blog for the user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BlogResource> createBlog(@RequestBody BlogResource sentBlog) {

		try {
			Blog blog = blogService.createBlog(sentBlog.toBlog());
			BlogResource blogResource = new BlogResourceAsm(BlogController.class, BlogResource.class).toResource(blog);
			return new ResponseEntity<BlogResource>(blogResource, HttpStatus.OK);
		} catch (BlogExistsException e) {
			throw new ConflictException(e);
		}

	}

	// find blog by ID
	@RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
	public ResponseEntity<BlogResource> findBlogById(@PathVariable String blogId) {
		Blog blog = blogService.findBlog(blogId);
		if (blog != null) {
			BlogResource blogResource = new BlogResourceAsm(BlogController.class, BlogResource.class).toResource(blog);
			return new ResponseEntity<BlogResource>(blogResource, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<BlogResource>(HttpStatus.NOT_FOUND);
		}
	}

	// create blog
	@RequestMapping(value = "/{blogId}/blog-entries", method = RequestMethod.POST)
	public ResponseEntity<BlogEntryResource> createBlogEntries(@PathVariable String blogId,
			@RequestBody BlogEntryResource sentBlogEntry) {
		try {
			BlogEntry blogCreated = blogService.createBlogEntry(blogId, sentBlogEntry.toBlogEntry());
			BlogEntryResource blogEntryResource = new BlogEntryResourceAsm(BlogController.class,
					BlogEntryResource.class).toResource(blogCreated);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(URI.create(blogEntryResource.getLink("self").getRel()));
			return new ResponseEntity<BlogEntryResource>(blogEntryResource, HttpStatus.OK);

		} catch (BlogNotFoundException exception) {

			throw new NotFoundException(exception);
		}
	}

	// find all blog entries
	@RequestMapping(value = "/{blogId}/blog-entries", method = RequestMethod.GET)

	public ResponseEntity<BlogEntryListResource> findAllBlogEntries(@PathVariable String blogId) {

		try {
			BlogEntryList listOfBlogs = blogService.findAllBlogEntries(blogId);
			BlogEntryListResource res = new BlogEntryListResourceAsm(BlogController.class, BlogEntryListResource.class)
					.toResource(listOfBlogs);
			return new ResponseEntity<BlogEntryListResource>(res, HttpStatus.OK);
		} catch (BlogNotFoundException exception) {
			throw new NotFoundException(exception);
		}

	}

	@RequestMapping(value = "/blog-categories", method = RequestMethod.GET)
	public ResponseEntity<BlogCategoryListResource> findAllBlogCategories() {
		try {
			BlogCategoryList blogCategories = blogCategoryService.findAllBlogCategories();
			BlogCategoryListResource res = new BlogCategoryListResourceAsm(BlogController.class,
					BlogCategoryListResource.class).toResource(blogCategories);
			return new ResponseEntity<BlogCategoryListResource>(res, HttpStatus.OK);
		} catch (BlogCategoryNotFoundException exception) {
			throw new NotFoundException(exception);
		}
	}


}
