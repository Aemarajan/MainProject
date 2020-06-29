package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="student_subject_Mapping")
public class StudSubMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="user",referencedColumnName="user_id")
	User user;
	
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

	public StudSubMapping() {	}

	public StudSubMapping(User user, Regulation regulation, Semester semester, Syllabus subject, int inn) {
		super();
		this.user = user;
		this.regulation = regulation;
		this.semester = semester;
		this.subject = subject;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "StudSubMapping [id=" + id + ", user=" + user + ", regulation=" + regulation + ", semester=" + semester
				+ ", subject=" + subject + ", inn=" + inn + "]";
	}
	
}
