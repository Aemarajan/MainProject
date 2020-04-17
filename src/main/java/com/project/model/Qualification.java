package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Qualification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	int user_id;
	String course;
	String medium_degree;
	String board_specification;
	String university;
	String institute_name;
	int year_of_passing;
	float percentage_cgpa;
	
	public Qualification() {}
	public Qualification(int user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMedium_degree() {
		return medium_degree;
	}
	public void setMedium_degree(String medium_degree) {
		this.medium_degree = medium_degree;
	}
	public String getBoard_specification() {
		return board_specification;
	}
	public void setBoard_specification(String board_specification) {
		this.board_specification = board_specification;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getInstitute_name() {
		return institute_name;
	}
	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}
	public int getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(int year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	public float getPercentage_cgpa() {
		return percentage_cgpa;
	}
	public void setPercentage_cgpa(float percentage_cgpa) {
		this.percentage_cgpa = percentage_cgpa;
	}

	@Override
	public String toString() {
		return "Qualification [id=" + id + ", user_id=" + user_id + ", course=" + course + ", medium_degree="
				+ medium_degree + ", board_specification=" + board_specification + ", university=" + university
				+ ", institute_name=" + institute_name + ", year_of_passing=" + year_of_passing + ", percentage_cgpa="
				+ percentage_cgpa + "]";
	}

}
