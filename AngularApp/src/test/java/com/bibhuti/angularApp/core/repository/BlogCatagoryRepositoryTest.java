package com.bibhuti.angularApp.core.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bibhuti.angularApp.core.model.entities.BlogCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringMongoConfigurationTest.xml")
public class BlogCatagoryRepositoryTest {

	@Autowired
	BlogCategoryRepository blogCategoryRepository;
	
	
	@Test
	public void addBlogCatagory(){
		BlogCategory blogCategory = new BlogCategory();
		blogCategory.setCategory("Automation");
		blogCategory.setId("1");
		blogCategory.setDescription("Explains automation processes");
		BlogCategory savedBlogCategory =blogCategoryRepository.save(blogCategory);
		assertNotNull(savedBlogCategory.getId());
	}
	
	@Test
	public void findAllBlogCategory(){
		List<BlogCategory> listOfBlogCategories = blogCategoryRepository.findAll();
		assertThat(listOfBlogCategories.isEmpty(), is(false));
	}
}
