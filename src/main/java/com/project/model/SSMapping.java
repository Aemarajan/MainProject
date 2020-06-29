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
@Table(name="staff_student_mapping")
public class SSMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="staff",referencedColumnName="user_id")
	User staff;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="student",referencedColumnName="user_id")
	User student;
	
	int inn;

	public SSMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SSMapping(int id, User staff, User student, int inn) {
		super();
		this.id = id;
		this.staff = staff;
		this.student = student;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "SSMapping [id=" + id + ", staff=" + staff + ", student=" + student + ", inn=" + inn + "]";
	}
	
}
