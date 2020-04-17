package com.project.customvalidator;

public class Address {
	
	int id;
	String door_no;
	String line1;
	String line2;
	String line3;
	int country;
	int state;
	int district;
	int pincode;
	boolean permanent;
	String p_door_no;
	String p_line1;
	String p_line2;
	String p_line3;
	int p_country;
	int p_state;
	int p_district;
	int p_pincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoor_no() {
		return door_no;
	}
	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public String getP_door_no() {
		return p_door_no;
	}
	public void setP_door_no(String p_door_no) {
		this.p_door_no = p_door_no;
	}
	public String getP_line1() {
		return p_line1;
	}
	public void setP_line1(String p_line1) {
		this.p_line1 = p_line1;
	}
	public String getP_line2() {
		return p_line2;
	}
	public void setP_line2(String p_line2) {
		this.p_line2 = p_line2;
	}
	public String getP_line3() {
		return p_line3;
	}
	public void setP_line3(String p_line3) {
		this.p_line3 = p_line3;
	}
	public int getP_country() {
		return p_country;
	}
	public void setP_country(int p_country) {
		this.p_country = p_country;
	}
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}
	public int getP_district() {
		return p_district;
	}
	public void setP_district(int p_district) {
		this.p_district = p_district;
	}
	public int getP_pincode() {
		return p_pincode;
	}
	public void setP_pincode(int p_pincode) {
		this.p_pincode = p_pincode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", door_no=" + door_no + ", line1=" + line1 + ", line2=" + line2 + ", line3="
				+ line3 + ", country=" + country + ", state=" + state + ", district=" + district + ", pincode="
				+ pincode + ", permanent=" + permanent + ", p_door_no=" + p_door_no + ", p_line1=" + p_line1
				+ ", p_line2=" + p_line2 + ", p_line3=" + p_line3 + ", p_country=" + p_country + ", p_state=" + p_state
				+ ", p_district=" + p_district + ", p_pincode=" + p_pincode + "]";
	}
	
}
