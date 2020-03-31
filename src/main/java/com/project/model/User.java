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
	
	String role;
	String name;
	String email;
	String username;
	String password;

	@Column(name="privilege_provide")
	int privilegeProvide;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	public int getPrivilegeProvide() {
		return privilegeProvide;
	}
	public void setPrivilegeProvide(int privilegeProvide) {
		this.privilegeProvide = privilegeProvide;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", role=" + role + ", name=" + name + ", email=" + email + ", username="
				+ username + ", password=" + password + ", privilegeProvide=" + privilegeProvide + "]";
	}	
}