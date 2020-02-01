package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddLevelTwo {

	@Select(message="* Select level one")
	int lvl1;
	
	@NotEmpty(message="* Name should not be null")
	@Size(min=3,max=20,message="* Size must be 3 to 20")
	String name;
	
	boolean dd;
	
	@NotEmpty(message="* Reference should not null")
	@Size(min=3,message="* Size minimum 3")
	String ref;
	
	
	public int getLvl1() {
		return lvl1;
	}
	public void setLvl1(int lvl1) {
		this.lvl1 = lvl1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDd() {
		return dd;
	}
	public void setDd(boolean dd) {
		this.dd = dd;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	@Override
	public String toString() {
		return "AddLevelTwo [name=" + name + ", dd=" + dd + ", ref=" + ref + "]";
	}
	
}
