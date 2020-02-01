package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int user_id;
	
	String username;
	String email;
	String password;

	@Column(name="privilege_provide")
	int privilegeProvide;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public int getPrivilegeProvide() {
		return privilegeProvide;
	}
	public void setPrivilegeProvide(int privilegeProvide) {
		this.privilegeProvide = privilegeProvide;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", privilegeProvide=" + privilegeProvide + "]";
	}
		
}
