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

	@Override
	public String toString() {
		return "LevelThree [lvl3_id=" + lvl3_id + ", name=" + name + "]";
	}
	
}
