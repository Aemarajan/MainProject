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
@Table(name = "experience")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	

	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private User user_id;
	
	String institute_name;
	String designation;
	String from_date;
	String to_date;
	int diff_years;
	int diff_months;
	int diff_days;
	int inn;

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Experience( User user_id, String institute_name, String designation, String from_date, String to_date,
			int diff_years, int diff_months, int diff_days, int inn) {
		super();
		this.user_id = user_id;
		this.institute_name = institute_name;
		this.designation = designation;
		this.from_date = from_date;
		this.to_date = to_date;
		this.diff_years = diff_years;
		this.diff_months = diff_months;
		this.diff_days = diff_days;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public int getDiff_years() {
		return diff_years;
	}

	public void setDiff_years(int diff_years) {
		this.diff_years = diff_years;
	}

	public int getDiff_months() {
		return diff_months;
	}

	public void setDiff_months(int diff_months) {
		this.diff_months = diff_months;
	}

	public int getDiff_days() {
		return diff_days;
	}

	public void setDiff_days(int diff_days) {
		this.diff_days = diff_days;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	public void setInn(boolean inn) {
		this.inn = Experience.check(inn);
	}

	public static int check(boolean bool) {
		int status = 0;
		if (bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", user_id=" + user_id + ", institute_name=" + institute_name + ", designation="
				+ designation + ", from_date=" + from_date + ", to_date=" + to_date + ", diff_years=" + diff_years
				+ ", diff_months=" + diff_months + ", diff_days=" + diff_days + ", inn=" + inn + "]";
	}
}
