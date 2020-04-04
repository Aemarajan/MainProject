package com.project.customvalidator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddState {

	int id;
	
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="* Enter Alphabet only")
	@NotEmpty(message="* Please enter state name")
	@Size(min=3,message="* Please enter minimum 3 character")
	String name;
	
	@Pattern(regexp = "^[a-zA-Z]*$",message="* Enter Alphabet only")
	@NotEmpty(message="* Please enter acronym name")
	@Size(min=2,message="* Please enter minimum 2 character")
	String acronym;
	
	boolean inn;
	
	public AddState() {
	}

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
