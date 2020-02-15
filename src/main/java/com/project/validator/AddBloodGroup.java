package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.Blood;
import com.project.customvalidator.NotEmpty;

public class AddBloodGroup {
	
	int id;
	
	@NotEmpty(message="* Please Enter the Blood Group name.")
	@Size(max=3,message="* Size should be maximum 3 characters.")
	@Blood(message="* Please Enter the Blood Group name with '+' or '-' symbols ")
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
