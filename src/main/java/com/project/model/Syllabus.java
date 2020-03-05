package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="syllabus_master")
public class Syllabus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String subject_code;
	
	String subject_name;
	
	int credit;
	
	int inn;
	
	public Syllabus() {
		// TODO Auto-generated constructor stub
	}

	public Syllabus(String subject_code, String subject_name, int credit, int inn) {
		super();
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.credit = credit;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "Syllabus [id=" + id + ", subject_code=" + subject_code + ", subject_name=" + subject_name + ", credit="
				+ credit + "]";
	}
	
}
