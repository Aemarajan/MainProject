package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddCountry {
	
	@NotEmpty(message="* Please enter the Country Name.")
	String name;
	
	@NotEmpty(message="* Please enter the Acronym.")
	@Size(max=3,min=2,message="* Size of the Acronym must be between 2 and 3.")
	String acronym;
	
	boolean inn;
	
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
