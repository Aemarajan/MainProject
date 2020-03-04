package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="year_master")
public class Year {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	int year;
	
	int inn;
	
	public Year() {
		// TODO Auto-generated constructor stub
	}

	public Year( int year, int inn) {
		super();
		this.year = year;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "Year [id=" + id + ", year=" + year + ", inn=" + inn + "]";
	}
	

}
