package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddLanguage {

	int id;
	
	@NotEmpty(message="* Enter the Language Name...")
	@Pattern(regexp="^[a-zA-Z\\s]*$",message="* Enter Alphabet only...")
	@Size(min=2,message="* Enter Minimum 2 Characters...")
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
