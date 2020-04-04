package com.project.customvalidator;

import java.util.Date;

public class Personal {
	
	int id;
	String username;
	Date dob;
	int blood;
	int religion;
	int community;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getReligion() {
		return religion;
	}
	public void setReligion(int religion) {
		this.religion = religion;
	}
	public int getCommunity() {
		return community;
	}
	public void setCommunity(int community) {
		this.community = community;
	}
	
	@Override
	public String toString() {
		return "Personal [id=" + id + ", username=" + username + ", dob=" + dob + ", blood=" + blood + ", religion="
				+ religion + ", community=" + community + "]";
	}
	
}
