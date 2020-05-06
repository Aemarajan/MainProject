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
	
	@NotEmpty(message="* Please Select Any One Category")
	String category;
	
	@NotEmpty(message="* Please enter Contact period")
	@Range(min=0,max=24,message="* Please enter minimum 0 to 24")
	Integer contact_period;
	
	@NotEmpty(message="* Please enter Lecture")
	@Range(min=0,max=24,message="* Please enter minimum 0 to 24")
	Integer lecture;
	
	@NotEmpty(message="* Please enter Tutorial")
	@Range(min=0,max=24,message="* Please enter minimum 0 to 24")
	Integer tutorial;
	
	@NotEmpty(message="* Please enter Practical")
	@Range(min=0,max=24,message="* Please enter minimum 0 to 24")
	Integer practical;
	
	@NotEmpty(message="* Please enter credit")
	@Range(min=1,max=10,message="* Please enter minimum 1 to 10")
	Integer credit;

	boolean inn;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getContact_period() {
		return contact_period;
	}

	public void setContact_period(Integer contact_period) {
		this.contact_period = contact_period;
	}

	public Integer getLecture() {
		return lecture;
	}

	public void setLecture(Integer lecture) {
		this.lecture = lecture;
	}

	public Integer getTutorial() {
		return tutorial;
	}

	public void setTutorial(Integer tutorial) {
		this.tutorial = tutorial;
	}

	public Integer getPractical() {
		return practical;
	}

	public void setPractical(Integer practical) {
		this.practical = practical;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
