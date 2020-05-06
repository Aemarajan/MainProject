package com.project.customvalidator;

import com.project.customannotations.Select;

public class SSMappingValidation {

	int id;
	
	@Select(message="* Please Select One Staff...")
	int staff;
	
	@Select(message="* Please Select One Student...")
	int student;

	boolean inn;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStaff() {
		return staff;
	}

	public void setStaff(int staff) {
		this.staff = staff;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
	
}
