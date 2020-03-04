package com.project.validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddYear {

	int id;
	
	@Select(message="* Please select degree")
	Integer degree;
	
	@NotEmpty(message="* Please enter year")
	@Min(value=1,message="* Please enter minimum value 1")
	@Max(value=5,message="* Please enter maximum value 6")
	Integer year;
	
	boolean inn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
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
