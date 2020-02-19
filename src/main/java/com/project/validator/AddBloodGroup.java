package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.Blood;
import com.project.customvalidator.NotEmpty;

public class AddBloodGroup {
	
	int id;
	
	@NotEmpty(message="* Blood group should not empty")
	@Size(max=3,message="* Size should be 3")
	@Blood(message="* Blood group must contain '+' or '-' ")
	String name;
	
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

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
	

}
