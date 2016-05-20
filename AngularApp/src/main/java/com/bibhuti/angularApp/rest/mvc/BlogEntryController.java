package com.bibhuti.angularApp.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.BlogEntryService;
import com.bibhuti.angularApp.rest.resources.BlogEntryResource;
import com.bibhuti.angularApp.rest.resources.asm.BlogEntryResourceAsm;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

	@Autowired
	BlogEntryService blogEntryService;

    //get blog by ID
	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntryBasedOnId(@PathVariable("blogEntryId") String blogId) {

		BlogEntry blogEntry = blogEntryService.findBlogEntryById(blogId);
		if(blogEntry!=null){
		BlogEntryResource blogEntryResource = new BlogEntryResourceAsm(BlogEntryController.class,
				BlogEntryResource.class).toResource(blogEntry);
		return new ResponseEntity<BlogEntryResource>(blogEntryResource, HttpStatus.OK);}
		else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}

	}

   //delete blog
	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.DELETE)
	public ResponseEntity<BlogEntryResource> deleteBlogEntry(@PathVariable("blogEntryId") String id) {
		BlogEntry blogEntry = blogEntryService.deleteBlogEntry(id);

		if (blogEntry != null) {
			BlogEntryResource blogEntryResource = new BlogEntryResourceAsm(BlogEntryController.class,
					BlogEntryResource.class).toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(blogEntryResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	//update blog
	@RequestMapping(value="/{blogEntryId}",method=RequestMethod.PUT)
	public ResponseEntity<BlogEntryResource> updateBlogEntry(@PathVariable("blogEntryId") String id, @RequestBody BlogEntry blogData){
		BlogEntry blogEntry = blogEntryService.updateBlogEntry(id, blogData);
		if(blogEntry!=null){
			BlogEntryResource blogEntryResource = new BlogEntryResourceAsm(BlogEntryController.class,
					BlogEntryResource.class).toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(blogEntryResource, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
