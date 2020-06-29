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
@Table(name="academic")
public class AcademicMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user",referencedColumnName="user_id")
	User user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="batch",referencedColumnName="id")
	Batch batch;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="regulation",referencedColumnName="id")
	Regulation regulation;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="degree",referencedColumnName="id")
	Degree degree;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="department",referencedColumnName="id")
	Department department;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="year",referencedColumnName="id")
	Year year;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="semester",referencedColumnName="id")
	Semester semester;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="section",referencedColumnName="id")
	Section section;

	int status;
	
	int inn;
	
	public AcademicMapping() {}

	public AcademicMapping(User user, Batch batch, Regulation regulation, Degree degree, Department department,
			Year year, Semester semester, Section section, int status, int inn) {
		super();
		this.user = user;
		this.batch = batch;
		this.regulation = regulation;
		this.degree = degree;
		this.department = department;
		this.year = year;
		this.semester = semester;
		this.section = section;
		this.status = status;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Regulation getRegulation() {
		return regulation;
	}

	public void setRegulation(Regulation regulation) {
		this.regulation = regulation;
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

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "AcademicMapping [id=" + id + ", user=" + user + ", batch=" + batch + ", regulation=" + regulation
				+ ", degree=" + degree + ", department=" + department + ", year=" + year + ", semester=" + semester
				+ ", section=" + section + ", status=" + status + ", inn=" + inn + "]";
	}
	
}
