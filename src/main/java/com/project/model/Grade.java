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
@Table(name="grade_master")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="regulation",referencedColumnName = "id")
	Regulation regulation;
	
	String word;
	String acronym;
	int point;
	int marks_range;
	int inn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Regulation getReguation() {
		return regulation;
	}
	public void setReguation(Regulation reguation) {
		this.regulation = reguation;
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
	public int getMarks_range() {
		return marks_range;
	}
	public void setMarks_range(int marks_range) {
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
		return "Grade [id=" + id + ", word=" + word + ", acronym=" + acronym + ", point=" + point + ", marks_range="
				+ marks_range + ", inn=" + inn + "]";
	}
}
