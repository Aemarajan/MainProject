package com.project.validator;

import com.project.customvalidator.NotEmpty;

public class ForgotPassword {

	int id;
	
	@NotEmpty(message="* Please Enter the Username...")
	String username;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
