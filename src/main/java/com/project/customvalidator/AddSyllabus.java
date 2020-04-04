package com.project.customvalidator;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.project.customannotations.NotEmpty;

public class AddSyllabus {
	
	int id;
	
	@NotEmpty(message="* Please enter subject code")
	@Pattern(regexp = "^[A-Z0-9]*$",message="*Please enter only alphabet and numbers")
	String subject_code;
	
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="* Please enter only alphabet")
	@NotEmpty(message="* Please enter subject name")
	String subject_name;
	
	@NotEmpty(message="* Please enter credit")
	@Range(min=1,max=10,message="* Please enter minimum 1 to 10")
	Integer credit;

	boolean inn;
	
	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	

}
