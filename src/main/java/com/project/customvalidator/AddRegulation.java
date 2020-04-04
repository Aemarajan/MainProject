package com.project.customvalidator;


import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddRegulation {

	int id;
	
	@NotEmpty(message="* Enter the Regulation Name...")
	String name;
	
	@NotEmpty(message="* Enter the Acronym...")
	@Size(min=3,message="* Enter Minimum 3 Characters...")
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
