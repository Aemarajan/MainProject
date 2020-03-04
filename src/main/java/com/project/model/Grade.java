package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_master")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String word;
	String acronym;
	int point;
	
	String marks_range;
	
	int inn;
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String word, String acronym, int point, String marks_range, int inn) {
		super();
		this.word = word;
		this.acronym = acronym;
		this.point = point;
		this.marks_range = marks_range;
		this.inn = inn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getMarks_range() {
		return marks_range;
	}
	public void setMarks_range(String marks_range) {
		this.marks_range = marks_range;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(boolean inn) {
		this.inn = Grade.check(inn);
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
		return "Grade [id=" + id + ", word=" + word + ", acronym=" + acronym + ", point="
				+ point + ", marks_range=" + marks_range + ", inn=" + inn + "]";
	}
}
