package com.project.customvalidator;

import com.project.customannotations.Select;

public class DeleteLevelThree {
	
	@Select(message="* Please Select level one Header.")
	int lvl1;
	
	@Select(message="* Please Select level two Header.")
	int lvl2;
	
	@Select(message="* Please Select level three Header.")
	int lvl3;

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

	public int getLvl3() {
		return lvl3;
	}

	public void setLvl3(int lvl3) {
		this.lvl3 = lvl3;
	}

	@Override
	public String toString() {
		return "DeleteLevelThree [lvl1=" + lvl1 + ", lvl2=" + lvl2 + ", lvl3=" + lvl3 + "]";
	}

}
