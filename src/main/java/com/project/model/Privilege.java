package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Privilege {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int privilege_id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="menu_id")
	Menu menu_id;
	
	int inn;

	public int getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Menu getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Menu menu_id) {
		this.menu_id = menu_id;
	}

	@Override
	public String toString() {
		return "Privilege [privilege_id=" + privilege_id + ", user=" + user + ", menu_id=" + menu_id + ", inn=" + inn
				+ "]";
	}

}
