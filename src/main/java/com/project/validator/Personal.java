package com.project.validator;

public class Personal {
	
	String id;
	String username;
	String dob;
	String blood;
	String religion;
	String community;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	
	@Override
	public String toString() {
		return "Personal [username=" + username + ", dob=" + dob + ", blood=" + blood + ", religion=" + religion
				+ ", community=" + community + "]";
	}

}
