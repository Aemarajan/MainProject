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
	@JoinColumn(name="csd",referencedColumnName = "id")
	CSDMapping csd;
	
	int pincode;
	
	int permanent;
	
	String p_door_no;
	String p_line1;
	String p_line2;
	String p_line3;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="p_csd",referencedColumnName = "id")
	CSDMapping p_csd;
	
	int p_pincode;
	
	int complete;
	
	public UserProfile() {}
	
	public UserProfile(int id) {
		this.id = id;
	}
	
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public CSDMapping getCsd() {
		return csd;
	}

	public void setCsd(CSDMapping csd) {
		this.csd = csd;
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

	public CSDMapping getP_csd() {
		return p_csd;
	}

	public void setP_csd(CSDMapping p_csd) {
		this.p_csd = p_csd;
	}

	public int getP_pincode() {
		return p_pincode;
	}

	public void setP_pincode(int p_pincode) {
		this.p_pincode = p_pincode;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getPermanent() {
		return permanent;
	}

	public void setPermanent(int permanent) {
		this.permanent = permanent;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", user_id=" + user_id + ", name=" + name + ", dob=" + dob + ", blood_id="
				+ blood_id + ", religion_id=" + religion_id + ", community_id=" + community_id + ", door_no=" + door_no
				+ ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", csd=" + csd + ", pincode=" + pincode
				+ ", permanent=" + permanent + ", p_door_no=" + p_door_no + ", p_line1=" + p_line1 + ", p_line2="
				+ p_line2 + ", p_line3=" + p_line3 + ", p_csd=" + p_csd + ", p_pincode=" + p_pincode + ", complete="
				+ complete + "]";
	}
	
}
