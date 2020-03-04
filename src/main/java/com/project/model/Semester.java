package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="semester_master")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	int inn;
	
	public Semester() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semester(String name, int inn) {
		super();
		this.name = name;
		this.inn = inn;
	}
	
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
	public int getInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = Semester.check(inn);
	}
	
	public static int check(boolean bool) {
		int status = 0;
		if(bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + ", inn=" + inn + "]";
	}

}
