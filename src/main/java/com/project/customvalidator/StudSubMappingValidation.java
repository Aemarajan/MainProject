package com.project.customvalidator;

import com.project.customannotations.Select;

public class StudSubMappingValidation {

	int id;
	
	@Select(message="* Please Select Any One Student...")
	int user;
	
	@Select(message="* Please Select Any Regulation...")
	int regulation;
	
	@Select(message="* Please Select Any Semester...")
	int semester;
	
	@Select(message="* Please Select Any Subject Code...")
	int subject;

	boolean inn;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getRegulation() {
		return regulation;
	}

	public void setRegulation(int regulation) {
		this.regulation = regulation;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}
	
	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "StudSubMappingValidation [id=" + id + ", user=" + user + ", regulation=" + regulation + ", semester="
				+ semester + ", subject=" + subject + ", inn=" + inn + "]";
	}
}
