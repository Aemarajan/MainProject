package com.project.customvalidator;

import com.project.customannotations.Select;

public class AcademicValidation {
	
	int user;
	
	@Select(message="* Please select batch")
	int batch;
	
	@Select(message="* Please select regulation")
	int regulation;
	
	@Select(message="* Please select degree")
	int degree;
	
	@Select(message="* Please select department")
	int department;
	
	@Select(message="* Please select year")
	int year;
	
	@Select(message="* Please select semester")
	int semester;
	
	@Select(message="* Please select section")
	int section;
	
	int status;
	
	boolean inn;

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public int getRegulation() {
		return regulation;
	}

	public void setRegulation(int regulation) {
		this.regulation = regulation;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

}