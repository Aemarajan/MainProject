package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.DegreeAnnotation;
import com.project.customvalidator.NotEmpty;

public class AddDegree {
	
	int id;
	
	@NotEmpty(message="* Enter the name")
	@Size(min=10,message="* Enter minimum 10 characters")
	String name;
	
	@DegreeAnnotation(message="* Please enter . (Dot) at valid place")
	@NotEmpty(message="* Enter the acronym")
	@Size(min=2,message="* Please enter mininum 2 characters")
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
