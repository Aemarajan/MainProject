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
@Table(name="rss_mapping")
public class RSSMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="regulation",referencedColumnName="id")
	Regulation regulation;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="semester",referencedColumnName="id")
	Semester semester;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="subject",referencedColumnName="id")
	Syllabus subject;
	
	int inn;

	public RSSMapping(Regulation regulation, Semester semester, Syllabus subject, int inn) {
		super();
		this.regulation = regulation;
		this.semester = semester;
		this.subject = subject;
		this.inn = inn;
	}

	public RSSMapping() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Regulation getRegulation() {
		return regulation;
	}

	public void setRegulation(Regulation regulation) {
		this.regulation = regulation;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Syllabus getSubject() {
		return subject;
	}

	public void setSubject(Syllabus subject) {
		this.subject = subject;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "RSSMapping [id=" + id + ", regulation=" + regulation + ", semester=" + semester + ", subject=" + subject
				+ ", inn=" + inn + "]";
	}	
}