package com.project.validator;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.project.customvalidator.AlphabetsOnly;
import com.project.customvalidator.*;

public final class SignUp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AlphabetsOnly(message="* Numeric value not allowed")
	@NotEmpty(message="* Username should not empty")
	String username;
	
	@NotEmpty(message="* Password should not empty")
	@Size(min=8,max=15,message="* Size must be 8 to 15")
	String password;
	
	@NotEmpty(message="* Email should not empty")
	@Email(message="* Invalid email")
	String email;
	
	@NotEmpty(message="* Confirm password should not empty")
	String confirmpassword;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
