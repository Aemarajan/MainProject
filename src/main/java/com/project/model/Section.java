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
@Table(name="section_master")
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="degree",referencedColumnName = "id")
	Degree degree;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="department",referencedColumnName = "id")
	Department department;
	
	Integer year;
	
	String name;
	
	int inn;
	
	public Section() {
	}
	
	public Section(Degree degree, Department department, String name, int inn) {
		super();
		this.degree = degree;
		this.department = department;
		this.name = name;
		this.inn = inn;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

}
