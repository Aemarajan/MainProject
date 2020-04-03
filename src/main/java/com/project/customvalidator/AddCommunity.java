package com.project.customvalidator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddCommunity {
	
	int id;
	
	@NotEmpty(message="* Name should not empty")
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="* Enter Alphabet only")
	String name;
	
	@NotEmpty(message="* Acronym should not empty")
	@Size(min=2,message="* Minimum 2 characters")
	@Pattern(regexp = "^[a-zA-Z]*$",message="* Enter Alphabet only")
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
