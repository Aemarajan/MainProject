package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lvl3")
public class LevelThree {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lvl3_id;
	
	private String name;

	private int inn;
	
	public int getLvl3_id() {
		return lvl3_id;
	}

	public void setLvl3_id(int lvl3_id) {
		this.lvl3_id = lvl3_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = LevelTwo.check(inn);
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
		return "LevelThree [lvl3_id=" + lvl3_id + ", name=" + name + ", inn=" + inn + "]";
	}

}
