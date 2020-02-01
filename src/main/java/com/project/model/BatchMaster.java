package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch_master")
public class BatchMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int from_year;
	private int to_year;
	private int no_of_years;
	private int inn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_year() {
		return from_year;
	}
	public void setFrom_year(int from_year) {
		this.from_year = from_year;
	}
	public int getTo_year() {
		return to_year;
	}
	public void setTo_year(int to_year) {
		this.to_year = to_year;
	}
	public int getNo_of_years() {
		return no_of_years;
	}
	public void setNo_of_years(int no_of_years) {
		this.no_of_years = no_of_years;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = BatchMaster.check(inn);
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
		return "BatchMaster [id=" + id + ", from_year=" + from_year + ", to_year=" + to_year + ", no_of_years="
				+ no_of_years + ", inn=" + inn + "]";
	}
}
