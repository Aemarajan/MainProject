package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddRegulation {

	int id;
	
	@NotEmpty(message="* Enter the Regulation Name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="Enter Alphabet only")
	String name;
	
	@NotEmpty(message="* Enter the Regulation Name")
	@Size(max=3,message="* Enter Minimum 3 Characters")
	@Pattern(regexp = "^[a-zA-Z\\.]*$",message="Enter Alphabet only")
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
