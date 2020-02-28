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
@Table(name="state_master")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	String acronym;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="country",referencedColumnName = "id")
	Country country;
	
	int inn;

	public State() {}
	
	public State(String name2, String acronym2, Country country2, int i) {
		name = name2;
		acronym = acronym2;
		country = country2;
		inn = i;
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = State.check(inn);
	}

	private static int check(boolean bool) {
		int status = 0;
		if(bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}
	
	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", acronym=" + acronym + ", country=" + country + ", inn=" + inn
				+ "]";
	}
}
