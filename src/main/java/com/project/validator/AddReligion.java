package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddReligion {

	int id;
	
	@NotEmpty(message="* Enter the Religion Name...")
	@Size(min=5,message="* Enter Minimum 5 Characters")
	@Pattern(regexp = "^[a-zA-Z]*$",message="Enter Alphabet only")
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
