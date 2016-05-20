package com.bibhuti.angularApp.core.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="account")
public class Account {

	@Id
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	

	public final String getId() {
		return this.id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public final String getName() {
		return this.name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getPassword() {
		return this.password;
	}
	public final void setPassword(final String password) {
		this.password = password;
	}
	
	public final String getConfirmPassword() {
		return this.confirmPassword;
	}
	public final void setConfirmPassword(final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
