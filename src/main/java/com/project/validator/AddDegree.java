package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddDegree {
	
	int id;
	
	@NotEmpty(message="* Enter the name")
	@Size(min=10,message="* Enter minimum 10 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="Enter Alphabet only")
	String name;
	
	@NotEmpty(message="* Enter the acronym")
	@Size(min=2,message="* Please enter mininum 2 characters")
	@Pattern(regexp = "^[a-zA-Z]*$",message="Enter Alphabet only")
	String acronym;
	
	@NotEmpty(message="* Please select category")
	String category;
	
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
