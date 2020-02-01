package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.model.LevelOne;

@Entity
@Table(name="lvl2")
public class LevelTwo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lvl2_id;
	
	private String name;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="lvl1_id",referencedColumnName = "lvl1_id")
	private LevelOne lvl1;
	
	private int dd;
	
	public int getLvl2_id() {
		return lvl2_id;
	}

	public void setLvl2_id(int lvl2_id) {
		this.lvl2_id = lvl2_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LevelOne getLvl1() {
		return lvl1;
	}

	public void setLvl1(LevelOne lvl1) {
		this.lvl1 = lvl1;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(boolean dd) {
		this.dd = LevelTwo.check(dd);
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
		return "LevelTwo [lvl2_id=" + lvl2_id + ", name=" + name + ", lvl1=" + lvl1 + ", dd=" + dd + "]";
	}

	
}
