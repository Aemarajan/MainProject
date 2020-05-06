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
	
	String category;
	
	int contact_period;
	
	int lecture;
	
	int tutorial;
	
	int practical;
	
	int credit;
	
	int inn;
	
	public Syllabus() {
		// TODO Auto-generated constructor stub
	}

	public Syllabus(String subject_code, String subject_name, String category, int contact_period, int lecture,
			int tutorial, int practical, int credit, int inn) {
		super();
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.category = category;
		this.contact_period = contact_period;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.practical = practical;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getContact_period() {
		return contact_period;
	}

	public void setContact_period(int contact_period) {
		this.contact_period = contact_period;
	}

	public int getLecture() {
		return lecture;
	}

	public void setLecture(int lecture) {
		this.lecture = lecture;
	}

	public int getTutorial() {
		return tutorial;
	}

	public void setTutorial(int tutorial) {
		this.tutorial = tutorial;
	}

	public int getPractical() {
		return practical;
	}

	public void setPractical(int practical) {
		this.practical = practical;
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

	public void setInn(boolean inn) {
		this.inn = Syllabus.check(inn);
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
		return "Syllabus [id=" + id + ", subject_code=" + subject_code + ", subject_name=" + subject_name
				+ ", category=" + category + ", contact_period=" + contact_period + ", lecture=" + lecture
				+ ", tutorial=" + tutorial + ", practical=" + practical + ", credit=" + credit + ", inn=" + inn + "]";
	}
}
