package com.project.validator;

import com.project.customvalidator.Select;

public class DeleteLevelTwo {
	
	@Select(message="* Please Select level one Header.")
	int lvl1;
	
	@Select(message="* Please Select level two Header.")
	int lvl2;

	public int getLvl1() {
		return lvl1;
	}

	public void setLvl1(int lvl1) {
		this.lvl1 = lvl1;
	}

	public int getLvl2() {
		return lvl2;
	}

	public void setLvl2(int lvl2) {
		this.lvl2 = lvl2;
	}

	@Override
	public String toString() {
		return "DeleteLevelTwo [lvl1=" + lvl1 + ", lvl2=" + lvl2 + "]";
	}
	
}
