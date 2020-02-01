package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lvl1")
public class LevelOne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lvl1_id;
	private String name;
	private int dd;
	
	public int getLvl1_id() {
		return lvl1_id;
	}
	public void setLvl1_id(int lvl1_id) {
		this.lvl1_id = lvl1_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(boolean dd) {
		this.dd = LevelOne.check(dd);
	}
	
	public static int check(Boolean bool) {
		int status = 0;
		if(bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}
	
	@Override
	public String toString() {
		return "LevelOne [lvl1_id=" + lvl1_id + ", name=" + name + ", dd=" + dd + "]";
	}
		
	
}
