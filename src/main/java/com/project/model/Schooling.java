package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schooling")
public class Schooling {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	int user_id;
	
	String course;
	
	String board;
	
	String institute;
	
	int year_of_passing;
	
	float percentage;

	public Schooling(){}
	
	public Schooling(int id,String course){
		this.id=id;
		this.course=course;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public int getYear_of_passing() {
		return year_of_passing;
	}

	public void setYear_of_passing(int year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	
	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Schooling [id=" + id + ", user_id=" + user_id + ", course=" + course + ", board=" + board
				+ ", institute=" + institute + ", year_of_passing=" + year_of_passing + ", percentage=" + percentage
				+ "]";
	}
	

}
