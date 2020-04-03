package com.project.customvalidator;

import javax.validation.constraints.Email;

import com.project.customannotations.NotEmpty;

public class ForgotPassword {

	int id;
	
	@NotEmpty(message="* Please Enter the Username...")
	@Email(message="* Please Enter the Valid Email Id...")
	String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
