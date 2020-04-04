package com.project.customvalidator;

import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;
import com.project.customannotations.Select;

public class AddLevelThree {
	
	@Select(message="* Select level one")
	int lvl1;
	
	@Select(message="* Select level two")
	int lvl2;
	
	@Select(message="* Select level three")
	int lvl3;
	
	@NotEmpty(message="* Reference should not empty")
	@Size(min=3,message="* Size minimum 3")
	String ref;

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

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "AddLevelThree [lvl1=" + lvl1 + ", lvl2=" + lvl2 + ", lvl3=" + lvl3 + ", ref=" + ref + "]";
	}

}
