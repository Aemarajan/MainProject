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
@Table(name="internal")
public class Internal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="subject_code",referencedColumnName="id")
	Syllabus subject_code;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="subject_name",referencedColumnName="id")
	Syllabus subject_name;
	
	int mark_entry_status;
	
	int internal1;
	
	int internal2;
	
	int internal3;
	
	int final_internal;

	int inn;
	
	public Internal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Internal(int id, Syllabus subject_code, Syllabus subject_name, int mark_entry_status, int internal1,
			int internal2, int internal3, int final_internal, int inn) {
		super();
		this.id = id;
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.mark_entry_status = mark_entry_status;
		this.internal1 = internal1;
		this.internal2 = internal2;
		this.internal3 = internal3;
		this.final_internal = final_internal;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Syllabus getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(Syllabus subject_code) {
		this.subject_code = subject_code;
	}

	public Syllabus getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(Syllabus subject_name) {
		this.subject_name = subject_name;
	}

	public int getMark_entry_status() {
		return mark_entry_status;
	}

	public void setMark_entry_status(int mark_entry_status) {
		this.mark_entry_status = mark_entry_status;
	}

	public int getInternal1() {
		return internal1;
	}

	public void setInternal1(int internal1) {
		this.internal1 = internal1;
	}

	public int getInternal2() {
		return internal2;
	}

	public void setInternal2(int internal2) {
		this.internal2 = internal2;
	}

	public int getInternal3() {
		return internal3;
	}

	public void setInternal3(int internal3) {
		this.internal3 = internal3;
	}

	public int getFinal_internal() {
		return final_internal;
	}

	public void setFinal_internal(int final_internal) {
		this.final_internal = final_internal;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	@Override
	public String toString() {
		return "Internal [id=" + id + ", subject_code=" + subject_code + ", subject_name=" + subject_name
				+ ", mark_entry_status=" + mark_entry_status + ", internal1=" + internal1 + ", internal2=" + internal2
				+ ", internal3=" + internal3 + ", final_internal=" + final_internal + "]";
	}
}
