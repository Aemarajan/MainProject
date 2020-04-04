package com.project.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private User user_id;
	
	String name;
	Date dob;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="blood_id",referencedColumnName = "id")
	private Bloodgroup blood_id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="religion_id",referencedColumnName = "id")
	private Religion religion_id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="community_id",referencedColumnName = "id")
	private Community community_id;
	
	String door_no;
	String line1;
	String line2;
	String line3;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="Country_id",referencedColumnName = "id")
	private Country country_id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="state_id",referencedColumnName = "id")
	private State state_id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="district_id",referencedColumnName = "id")
	private District district_id;
	
	int pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Bloodgroup getBlood_id() {
		return blood_id;
	}

	public void setBlood_id(Bloodgroup blood_id) {
		this.blood_id = blood_id;
	}

	public Religion getReligion_id() {
		return religion_id;
	}

	public void setReligion_id(Religion religion_id) {
		this.religion_id = religion_id;
	}

	public Community getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(Community community_id) {
		this.community_id = community_id;
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

	public Country getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Country country_id) {
		this.country_id = country_id;
	}

	public State getState_id() {
		return state_id;
	}

	public void setState_id(State state_id) {
		this.state_id = state_id;
	}

	public District getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(District district_id) {
		this.district_id = district_id;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", user_id=" + user_id + ", name=" + name + ", dob=" + dob + ", blood_id="
				+ blood_id + ", religion_id=" + religion_id + ", community_id=" + community_id + ", door_no=" + door_no
				+ ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", country_id=" + country_id
				+ ", state_id=" + state_id + ", district_id=" + district_id + ", pincode=" + pincode + "]";
	}
	
}
