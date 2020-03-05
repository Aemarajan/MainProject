package com.project.validator;

import org.hibernate.validator.constraints.Range;

import com.project.customvalidator.NotEmpty;

public class AddYear {

	int id;
	
	@NotEmpty(message="* Please enter year")
	@Range(min=1,max=6,message="* Enter the number 1 to 6.")
	Integer year;
	
	boolean inn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
	
}
