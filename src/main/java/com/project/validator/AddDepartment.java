package com.project.validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customvalidator.Dot;
import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddDepartment {
	
	int id;
	
	@NotEmpty(message="* Please enter department name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="Enter Alphabet only")
	String name;
	
	@Dot(message="* Please enter . (Dot) at valid place")
	@NotEmpty(message="* Please enter acronym")
	@Size(min=2,message="* Please enter minimum 2 characters")
	@Pattern(regexp = "^[a-zA-Z\\.{3}]*$",message="Enter Alphabet only")
	String acronym;
	
	@Select(message="* Please select degree")
	Integer degree;
	
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

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
