package com.project.validator;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddSection {

	int id;
	
	@Select(message="* Please select degree")
	Integer degree;
	
	@Select(message="* Please select department")
	Integer department;
	
	@Select(message="* Please select year")
	Integer year;
	
	@NotEmpty(message="* Please enter section name")
	String name;
	
	boolean inn;
	
	public AddSection() {
	}

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

	public boolean isInn() {
		return inn;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
