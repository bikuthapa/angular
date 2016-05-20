package com.bibhuti.angularApp.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.endsWith; 
import static org.hamcrest.Matchers.hasItem; 
import static org.hamcrest.Matchers.is; 
import static org.mockito.Matchers.any; 
import static org.mockito.Matchers.eq; 
import static org.mockito.Mockito.when; 
import com.jayway.jsonpath.*;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.BlogEntryService;
import com.bibhuti.angularApp.rest.mvc.BlogEntryController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; 


public class BlogEntryControllerTest {

@InjectMocks
private BlogEntryController blogEntryController;

@Mock 
BlogEntryService blogEntryService;

private  MockMvc mockMvc;


@Before
public void setup(){
	MockitoAnnotations.initMocks(this);
	mockMvc= MockMvcBuilders.standaloneSetup(blogEntryController).build();
	
}
@Ignore
public void getExistingBlogEntryById() throws Exception{
	BlogEntry blogEntry = new BlogEntry();
	blogEntry.setTitle("TEST");
	blogEntry.setId("1");
	
	Blog blog = new Blog();
	blog.setId("1");
	blogEntry.setBlog(blog);
	when(blogEntryService.findBlogEntryById("1")).thenReturn(blogEntry);
	mockMvc.perform(get("/rest/blog-entries/1"))
    .andDo(print()) 
    .andExpect(jsonPath("$.title", is(blogEntry.getTitle()))) 
    .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1")))) 
    .andExpect(status().isOk());
  
}
@Test
public void getNonExistingBlogEntryById() throws Exception
{	   when(blogEntryService.findBlogEntryById("1")).thenReturn(null);
       mockMvc.perform(get("/rest/blog-entries/1"))
          .andExpect(status().isNotFound());
   }

@Ignore
public void deleteExistingBlogEntry() throws Exception {
    BlogEntry deletedBlogEntry = new BlogEntry();
    deletedBlogEntry.setId("1");
    deletedBlogEntry.setTitle("Test Title");

    when(blogEntryService.deleteBlogEntry("1")).thenReturn(deletedBlogEntry);

    mockMvc.perform(delete("/rest/blog-entries/1"))
            .andExpect(jsonPath("$.title", is(deletedBlogEntry.getTitle())))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
            .andExpect(status().isOk());
}
@Ignore
public void deleteNonExistingBlog() throws Exception
{
	when(blogEntryService.deleteBlogEntry("1")).thenReturn(null);
	mockMvc.perform(delete("/rest/blog-entries/1"))
	.andDo(print())
	.andExpect(status().isNotFound());
}

@Ignore
public void updateExistingBlog()throws Exception
{
	 BlogEntry updatedBlogEntry = new BlogEntry();
	 updatedBlogEntry.setId("1");
	 updatedBlogEntry.setTitle("Test Title");

	 when(blogEntryService.updateBlogEntry(eq("1"),any(BlogEntry.class))).thenReturn(updatedBlogEntry);
	 mockMvc.perform(put("/rest/blog-entries/1")
             .content("{\"title\":\"Test Title\"}")
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(jsonPath("$.title", is(updatedBlogEntry.getTitle())))
             .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
             .andExpect(status().isOk());
}

@Ignore
public void updateNonExistingBlog()throws Exception
 {
	 when(blogEntryService.updateBlogEntry(eq("1"),any(BlogEntry.class))).thenReturn(null);
	 mockMvc.perform(put("/rest/blog-entries/1")
	 .content("{\"title\":\"Test Title\"}")
     .contentType(MediaType.APPLICATION_JSON))
	 .andExpect(status().isNotFound());
  }

}
