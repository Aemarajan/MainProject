package com.project.customvalidator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;
import com.project.customannotations.PastYear;

public class AddBatchMaster {
	
	int id;
	
	@PastYear(message="* Future year not allowed")
	@NotEmpty(message="* From year should not empty")
	@Size(max=4,message="* Size should be 4")
	@Pattern(regexp="[0-9]+",message="* Numbers only allowed")
	String from_year;
	
	@NotEmpty(message="* To year should not empty")
	@Size(max=4,message="* Size should be 4")
	@Pattern(regexp="[0-9]+",message="* Numbers only allowed")
	String to_year;
	
	boolean inn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom_year() {
		return from_year;
	}
	public void setFrom_year(String from_year) {
		this.from_year = from_year;
	}
	public String getTo_year() {
		return to_year;
	}
	public void setTo_year(String to_year) {
		this.to_year = to_year;
	}
	public boolean isInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = inn;
	}
}
