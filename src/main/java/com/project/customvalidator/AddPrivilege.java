package com.project.customvalidator;

import com.project.customannotations.Select;

public class AddPrivilege {

	@Select(message="* Please Select Any User...")
	int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
