package com.project.customvalidator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddSemester {

	int id;
	
	@NotEmpty(message="* Please Enter Semester Name...")
	@Pattern(regexp="^[IVX]*$",message="* Please Enter a  valid Semester name...")
	@Size(min=1,max=4,message="* Please Enter Minimum 2 Characters and Maximum 4 characters...")
	String name;
	
	boolean inn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
	
}
