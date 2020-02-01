package com.project.validator;

import javax.validation.constraints.Email;

import com.project.customvalidator.NotEmpty;

public class SignIn {

	@NotEmpty(message="* Email should not empty")
	@Email(message="* Invalid Email")
	String email;
	
	@NotEmpty(message="* Password should not empty")
	String password;
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignIn [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
