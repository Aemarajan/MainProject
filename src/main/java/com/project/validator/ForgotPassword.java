package com.project.validator;

import javax.validation.constraints.Email;

import com.project.customvalidator.NotEmpty;

public class ForgotPassword {
	
	@NotEmpty(message="* Please Enter the Username...")
	@Email(message="* Please Enter the Valid Email Id...")
	String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
