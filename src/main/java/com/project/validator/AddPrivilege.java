package com.project.validator;

import com.project.customvalidator.Select;

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
