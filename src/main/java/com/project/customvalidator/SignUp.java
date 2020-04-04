package com.project.customvalidator;

import javax.validation.constraints.Email;

import com.project.customannotations.NotEmpty;

public class SignUp {
		
	@NotEmpty(message="* Please Select Any Role...")
	String role;
	
	//@AlphabetsOnly(message="* Please Enter the Characters only")
	@NotEmpty(message="* Please Enter the Name")
	String name;
	
	@NotEmpty(message="* Please Enter the Email.")
	@Email(message="* Please Enter Valid Email.")
	String email;
	
	@NotEmpty(message="* Please Enter the Username")
	String username;
	
	String password;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
