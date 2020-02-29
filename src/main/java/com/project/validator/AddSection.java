package com.project.validator;

import javax.validation.constraints.Pattern;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddSection {

	int id;
	
	@Select(message="* Please Select Year")
	Integer year;
	
	@NotEmpty(message="* Please enter section Name...")
	@Pattern(regexp="^[a-zA-Z]*$",message="* Enter Alphabet Only...") 
	String name;
	
	boolean inn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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