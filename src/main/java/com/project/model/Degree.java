package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="degree_master")
public class Degree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String category;
	String name;
	String acronym;
	int inn;
	
	public Degree(){}
	
	public Degree( String category, String name, String acronym, int inn) {
		super();
		this.category = category;
		this.name = name;
		this.acronym = acronym;
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
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(int inn) {
		this.inn = inn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "DegreeMaster [id=" + id + ", name=" + name + ", acronym=" + acronym + ", inn=" + inn + "]";
	}
}
