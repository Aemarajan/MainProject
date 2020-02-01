package com.project.validator;

import javax.validation.constraints.Size;

import com.project.customvalidator.NotEmpty;

public class AddLevelOne {

	@NotEmpty(message="* Header field not empty")
	@Size(min=3,max=20,message="* Size must be 3 to 20")
	String name;
	
	boolean dd;
	
	@NotEmpty(message="* Reference field should not empty")
	@Size(min=3,message="* Size minimum 3")
	String ref;
	
	public AddLevelOne(String string, boolean b, String string2) {
		// TODO Auto-generated constructor stub
		super();
		name=string;
		dd=b;
		ref=string2;
	}
	
	public AddLevelOne() {
		super();
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
		return "AddLevelOne [name=" + name + ", dd=" + dd + ", ref=" + ref + "]";
	}
	
}
