package com.bibhuti.angularApp.core.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.Matchers.is;
import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringMongoConfigurationTest.xml")
public class BlogRepositoryTest {

	@Autowired
	BlogRepository blogRepository;

	@Test
	@Rollback(false)
	public void createBlog() {
		Blog blog = new Blog();
		BlogCategory blogCategory = new BlogCategory();
	    blogCategory.setCategory("Automation 201");
		blog.setId("1");
		Account account = new Account();
		account.setName("Bibhuti");
		account.setId("1");
		blog.setOwner(account);
		Blog savedBlogEntry = blogRepository.save(blog);
		assertNotNull(savedBlogEntry.getId());
	}

	@Ignore
	public void findAllBlogs() {
		List<Blog> allBlogs = blogRepository.findAll();
		assertThat(allBlogs.isEmpty(), is(false));
	}

	@Test
	public void findBlogById() {
		Blog blogFoundById = blogRepository.findBlogById("1");
		assertNotNull(blogFoundById.getId());
	}

	@Ignore
	public void findAllBlogEntries() {

	}
}
