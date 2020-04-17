package com.project.model;

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

	int privilege_provide;

	int inn;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String role, String name, String email, String username, String password,
			int privilege_provide, int inn) {
		super();
		this.role = role;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.privilege_provide = privilege_provide;
		this.inn =inn;
	}

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
	public int getPrivilege_provide() {
		return privilege_provide;
	}
	public void setPrivilege_provide(int privilege_provide) {
		this.privilege_provide = privilege_provide;
	}
	public void setInn(int inn) {
		this.inn = inn;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = User.check(inn);
	}

	private static int check(boolean bool) {
		int status = 0;
		if(bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", role=" + role + ", name=" + name + ", email=" + email + ", username="
				+ username + ", password=" + password + ", privilege_provide=" + privilege_provide + ", inn=" + inn
				+ "]";
	}	
}