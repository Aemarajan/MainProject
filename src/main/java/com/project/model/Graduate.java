package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="graduate")
public class Graduate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	int user_id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="degree",referencedColumnName="id")
	Degree degree;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="department",referencedColumnName="id")
	Department department;
	
	String university;
	
	String institute;
	
	int year_of_passing;
	
	float cgpa;

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

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public int getYear_of_passing() {
		return year_of_passing;
	}

	public void setYear_of_passing(int year_of_passing) {
		this.year_of_passing = year_of_passing;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Graduate [id=" + id + ", user_id=" + user_id + ", degree=" + degree + ", department=" + department
				+ ", university=" + university + ", institute=" + institute + ", year_of_passing=" + year_of_passing
				+ ", cgpa=" + cgpa + "]";
	}

	
}
