package com.project.customvalidator;

import javax.validation.constraints.Pattern;

import com.project.customannotations.NotEmpty;
import com.project.model.User;

public class ExperienceValidation {

	int id;
	
	User user_id;
	
	@NotEmpty(message = "* Please Enter the Institute name...")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "* Please Enter only Characters...")
	String institute_name;

	@NotEmpty(message = "* Please Enter the Designation...")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "* Please Enter only Characters...")
	String designation;

	@NotEmpty(message = "* Please Enter the From Date...")
	String from_date;

	@NotEmpty(message = "* Please Enter the To Date...")
	String to_date;

	boolean inn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
