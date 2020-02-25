package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddCountry {
	
	int id;
	
	@NotEmpty(message="* Name should not empty")
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="Enter Alphabet only")
	String name;
	
	@NotEmpty(message="* Acronym should not empty")
	@Size(max=3,min=2,message="* Size between 2 to 3")
	@Pattern(regexp = "^[a-zA-Z]*$",message="Enter Alphabet only")
	String acronym;
	
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
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public boolean isInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = inn;
	}
	
}
