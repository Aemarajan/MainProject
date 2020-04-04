package com.project.customvalidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddGrade {

	int id;
	
	@NotEmpty(message="* Please Enter Grade Word...")
	@Pattern(regexp="^[a-zA-Z]*$",message="* Please Enter Alphabet Only...")
	@Size(min=4,message="* Please Enter Minimum 4 Characters...")
	String word;
	
	@NotEmpty(message="* Please Enter the Acronym...")
	@Pattern(regexp="^[a-zA-Z]*$",message="* Please Enter Alphabet Only...")
	@Size(min=1,max=2,message="* Please Enter Minimum 1 Character and Maximum 2 Characters...")
	String acronym;
	
	@NotEmpty(message="* Please Enter Grade Point...")
	@Min(value=0,message="* Please Enter the Numeric Value between 0 to 10...")
	@Max(value=10,message="* Please Enter the Numeric Value between 0 to 10...")
	Integer point;
	
	@NotEmpty(message="* Please Enter Grade Marks Range...")
	@Pattern(regexp="^[0-9\\-]*$",message="* Please Enter the Numbers Only...[Example : 91-100]")
	String marks_range;
	
	boolean inn;
	
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

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getMarks_range() {
		return marks_range;
	}

	public void setMarks_range(String marks_range) {
		this.marks_range = marks_range;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
}
