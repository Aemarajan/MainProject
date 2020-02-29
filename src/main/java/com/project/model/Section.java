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
	@JoinColumn(name="year",referencedColumnName = "id")
	Year year;
	
	String name;
	
	int inn;
	
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Section(int id, Year year, String name, int inn) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
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

	@Override
	public String toString() {
		return "Section [id=" + id + ", year=" + year + ", name=" + name + ", inn=" + inn + "]";
	}
}
