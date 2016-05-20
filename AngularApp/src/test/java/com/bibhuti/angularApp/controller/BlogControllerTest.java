package com.bibhuti.angularApp.controller;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Matchers.eq; 
import static org.mockito.Matchers.any;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.BlogService;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;
import com.bibhuti.angularApp.core.service.util.BlogEntryList;
import com.bibhuti.angularApp.rest.mvc.BlogController;

public class BlogControllerTest {
		
	@Mock
	BlogService blogService;
	
	@InjectMocks
	BlogController blogController;
	private ArgumentCaptor<Blog> accountCaptor;
    private  MockMvc mockMvc;
    
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
		accountCaptor = ArgumentCaptor.forClass(Blog.class);
	}
	
	@Ignore
	public void findAllAvailableBlogs()throws Exception{
		
	}
	@Ignore
	public void findBlogByExistingId() throws Exception{
		Blog blog= new Blog();
		blog.setId("1");
		BlogCategory blogCategory = new BlogCategory();
	    blogCategory.setCategory("Title");
		when(blogService.findBlog("1")).thenReturn(blog);
		mockMvc.perform(get("/rest/blogs/1"))
		             .andDo(print())
		             .andExpect(jsonPath("$.title", is(blog.getBlogCategory())))
		             .andExpect(status().isOk());
		
	   }
	@Ignore
	public void findBlogByNonExistingId()throws Exception{
		when(blogService.findBlog("1")).thenReturn(null);
		mockMvc.perform(get("/rest/blogs/1"))
		        .andDo(print())
		        .andExpect(status().isNotFound());
		
	}
	@Ignore
	public void createBlogEntriesExistingBlog()throws Exception{
		Blog blog = new Blog();
        blog.setId("1");

        BlogEntry entry = new BlogEntry();
        entry.setTitle("Test Title");
        entry.setId("1");

        when(blogService.createBlogEntry(eq("1"), any(BlogEntry.class))).thenReturn(entry);

        mockMvc.perform(post("/rest/blogs/1/blog-entries")
                .content("{\"title\":\"Generic Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("rest/blog-entries/1"))))
                .andExpect(header().string("Location", endsWith("rest/blog-entries/1")))
                .andExpect(status().isCreated());
      } 
	
	@Ignore
	public void createBlogEntriesNonExistingBlog()throws Exception{
		  when(blogService.createBlogEntry(eq("1"), any(BlogEntry.class))).thenThrow(new BlogNotFoundException());
		 mockMvc.perform(post("/rest/blogs/1/blog-entries")
	                .content("{\"title\":\"Generic Title\"}")
	                .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isNotFound());
	}
		
	@Test
	public void listBlogEntriesForExistingBlog()throws Exception{
		BlogEntryList blogEntryList = new BlogEntryList();
		blogEntryList.setBlogId(1L);
		
		when(blogService.findAllBlogEntries("1")).thenReturn(blogEntryList);
		mockMvc.perform(get("/rest/blogs/1/blog-entries"))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	public void listBlogEntriesForNonExistingBlog()throws Exception{
		when(blogService.findAllBlogEntries("1")).thenThrow(new BlogNotFoundException());
		mockMvc.perform(get("/rest/blogs/1/blog-entries"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}
}
