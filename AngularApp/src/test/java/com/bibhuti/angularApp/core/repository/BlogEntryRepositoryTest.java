package com.bibhuti.angularApp.core.repository;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringMongoConfigurationTest.xml")
public class BlogEntryRepositoryTest {
	
	@Autowired
	BlogEntryRepository blogEntryRepository;
	
	@Test
	@Rollback(false)
	public void createBlogEntry(){
		
		Date date= new java.util.Date();
		BlogEntry blogEntry = new BlogEntry();
		Blog blog = new Blog();
		BlogCategory blogCategory = new BlogCategory();
	    blogCategory.setCategory("Automation 101");
		blogEntry.setTitle("First automation blog Entry");
		blogEntry.setId("1");
		blogEntry.setContent("This is a very long blog");
		blogEntry.setBlog(blog);
		blogEntry.setBlogCreateDate(new Timestamp(date.getTime()));
		BlogEntry addedBlogEntry = blogEntryRepository.save(blogEntry);
		assertNotNull(addedBlogEntry.getId());
	}
 
	@Test
	public void findBlogEntryById(){
	 BlogEntry blogEntry = blogEntryRepository.findBlogEntryById("1");
	 assertNotNull(blogEntry.getId());
	}
	
	@Ignore
	@Rollback(true)
	public void deleteBlogEntry(){
		BlogEntry blogEntry = blogEntryRepository.findBlogEntryById("1");
		 blogEntryRepository.delete(blogEntry);
	}
	@Ignore
	public void updateBlogEntry(){
		BlogEntry blogEntry = blogEntryRepository.findBlogEntryById("1");
		BlogEntry newBlogEntry = new BlogEntry();
		Blog blog = new Blog();
		BlogCategory blogCategory = new BlogCategory();
	    blogCategory.setCategory("Automation 102");
		newBlogEntry.setTitle("Second automation blog Entry");
		newBlogEntry.setId("1");
		newBlogEntry.setContent("This is a very long blog");
		newBlogEntry.setBlog(blog);
		blogEntryRepository.save(newBlogEntry);
	}
	
	
}
