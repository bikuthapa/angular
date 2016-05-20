package com.bibhuti.angularApp.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq; 
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bibhuti.angularApp.core.model.entities.Account;
import com.bibhuti.angularApp.core.model.entities.Blog;
import com.bibhuti.angularApp.core.model.entities.BlogCategory;
import com.bibhuti.angularApp.core.service.AccountService;
import com.bibhuti.angularApp.core.service.exceptions.AccountDoesNotExistException;
import com.bibhuti.angularApp.core.service.exceptions.AccountExistsException;
import com.bibhuti.angularApp.rest.mvc.AccountController;

public class AccountControllerTest {

	@InjectMocks
	AccountController controller;

	@Mock
	AccountService service;

	private MockMvc mockMvc;
	private ArgumentCaptor<Account> accountCaptor;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		accountCaptor = ArgumentCaptor.forClass(Account.class);
	}

	@Ignore
	public void getAccountById() throws Exception {
		Account account = new Account();
		account.setName("Test");
		account.setPassword("Test");
		account.setId("1");

		when(service.findAccount("1")).thenReturn(account);
		mockMvc.perform(get("/rest/accounts/1")).andDo(print())
				.andExpect(jsonPath("$.password", is(account.getPassword())))
				.andExpect(jsonPath("$.name", is(account.getName()))).andExpect(status().isOk());

	}
	
	@Ignore
	public void getNotExistingAccountById()throws Exception {
		when(service.findAccount("1")).thenReturn(null);
		mockMvc.perform(get("/rest/accounts/1"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}

	@Ignore
	public void addingNonExistingAccount() throws Exception {
		Account createdAccount = new Account();
		createdAccount.setName("Test");
		createdAccount.setPassword("Test");
		createdAccount.setId("1");
		when(service.createAccount(any(Account.class))).thenReturn(createdAccount);
		mockMvc.perform(post("/rest/accounts").content("{\"name\":\"test\",\"password\":\"test\"}")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.name", is(createdAccount.getName()))).andExpect(status().isCreated());
		verify(service).createAccount(accountCaptor.capture());
		String password = (accountCaptor.getValue()).getPassword();
		assertEquals("test", password);
	}

	@Ignore
	public void addingExistingAccount() throws Exception {
		Account createdAccount = new Account();
		createdAccount.setName("Test");
		createdAccount.setPassword("Test");
		createdAccount.setId("1");
		when(service.createAccount(any(Account.class))).thenThrow(new AccountExistsException());
		mockMvc.perform(post("/rest/accounts").content("{\"name\":\"test\",\"password\":\"test\"}")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isConflict());

	}

	@Ignore
	public void createBlogForExistingAccount() throws Exception {
        Blog createdBlog = new Blog();
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setCategory("Title");
        createdBlog.setId("1");
        createdBlog.setBlogCategory(blogCategory);

        when(service.createBlog(eq("1"), any(Blog.class))).thenReturn(createdBlog);

        mockMvc.perform(post("/rest/accounts/1/blogs")
                .content("{\"title\":\"Test Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.title", is("Test Title")))
                .andExpect(status().isCreated());
    }

	@Ignore
	public void createBlogForNonExistingAccount() throws Exception {
		when(service.createBlog(eq("1"), any(Blog.class))).thenThrow(new AccountDoesNotExistException());
		mockMvc.perform(post("/rest/accounts/1/blogs").content("{\"title\":\new Title\"}")
				.contentType(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isNotFound());
	}

}
