package com.project.validator;

import javax.validation.constraints.Pattern;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddState {

	int id;
	
	@Pattern(regexp = "^[a-zA-Z\\s]*$",message="* Enter Alphabet only")
	@NotEmpty(message="* Please enter state name")
	String name;
	
	@Pattern(regexp = "^[a-zA-Z]*$",message="* Enter Alphabet only")
	@NotEmpty(message="* Please enter acronym name")
	String acronym;
	
	@Select(message="* Please select country")
	Integer country;
	
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

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
