package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;
import com.project.customvalidator.Select;

public class AddLevelTwo {

	@Select(message="* Please Select level one Header.")
	int lvl1;
	
	@NotEmpty(message="* Please enter the Header Name.")
	@Size(min=3,max=20,message="* Size of the Header name should have minimum 3 characters and at the maximum of 20 characters.")
	String name;
	
	boolean dd;
	
	@NotEmpty(message="* Please enter the Reference.")
	@Size(min=3,message="* Size of the reference should have at the minimum of 3 Characters.")
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