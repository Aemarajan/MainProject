package com.project.customvalidator;

import com.project.customannotations.NotEmpty;
import com.project.model.LevelOne;

public class LevelOneValidation {

	int lvl1_id;
	
	int lvl2_id;
	
	int lvl3_id;
	
	private LevelOne lvl1;
	
	@NotEmpty(message="* Please Enter The Name...")
	String name;
	
	int dd;
	
	boolean inn;

	public int getLvl1_id() {
		return lvl1_id;
	}

	public void setLvl1_id(int lvl1_id) {
		this.lvl1_id = lvl1_id;
	}
	
	public int getLvl2_id() {
		return lvl2_id;
	}

	public void setLvl2_id(int lvl2_id) {
		this.lvl2_id = lvl2_id;
	}

	public int getLvl3_id() {
		return lvl3_id;
	}

	public void setLvl3_id(int lvl3_id) {
		this.lvl3_id = lvl3_id;
	}

	public LevelOne getLvl1() {
		return lvl1;
	}

	public void setLvl1(LevelOne lvl1) {
		this.lvl1 = lvl1;
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

	public void setDd(int dd) {
		this.dd = dd;
	}

	public boolean isInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = inn;
	}
	
}
