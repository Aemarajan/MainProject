package com.project.validator;

import com.project.customvalidator.Select;

public class ModifyPrivilege {

	int id;
	
	@Select(message="* Please Select Any User...")
	int user_id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
