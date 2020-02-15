package com.project.validator;

import com.project.customvalidator.Select;

public class DeleteLevelOne {

	@Select(message="* Please Select level one Header.")
	int lvl1;

	public int getLvl1() {
		return lvl1;
	}

	public void setLvl1(int lvl1) {
		this.lvl1 = lvl1;
	}

}
