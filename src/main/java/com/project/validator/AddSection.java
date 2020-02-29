package com.project.validator;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddSection {

	int id;
	
	@Select(message="* Please select degree")
	Integer degree;
	
	@Select(message="* Please select department")
	Integer department;
	
	@NotEmpty(message="* Please enter section name")
	String section;
	
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

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}
