package com.project.customvalidator;

import com.project.customannotations.Select;

public class AddCSD {

	int id;
	
	@Select(message="* Please select any country")
	int country;
	
	@Select(message="* Please select any state")
	int state;
	
	@Select(message="* Please select any district")
	int district;
	
	boolean inn;

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "AddCSD [id=" + id + ", country=" + country + ", state=" + state + ", district=" + district + "]";
	}
	
}
