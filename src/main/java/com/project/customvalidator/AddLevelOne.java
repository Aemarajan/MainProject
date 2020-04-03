package com.project.customvalidator;

import javax.validation.constraints.Size;

import com.project.customannotations.NotEmpty;

public class AddLevelOne {

	@NotEmpty(message="* Please enter the Header Name.")
	@Size(min=3,max=20,message="* Size of the Header name should have minimum 3 and maximum 20 characters.")
	String name;
	
	boolean dd;
	
	@NotEmpty(message="* Please Enter the Reference.")
	@Size(min=3,message="* Size of the reference should have at the minimum of 3 Characters.")
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
