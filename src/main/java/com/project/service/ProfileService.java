package com.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.CSDMapping;
import com.project.model.UserProfile;
import com.project.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;
	
	public void updatePersonal(Date dob, int blood, int religion, int community, int id) {
		profileRepo.updatePersonal(dob,blood,religion,community,id);
	}
	
	public void updateAddress(int id, String door, String line1, String line2, String line3, CSDMapping csd, int pincode,
			int permanent, String pdoor, String pline1, String pline2, String pline3, CSDMapping pcsd,int ppincode) {
		profileRepo.updateAddress(id, door, line1, line2, line3, csd, pincode, permanent, pdoor, pline1, pline2, pline3, pcsd, ppincode);
	}

	public void createUserProfile(int user_id) {
		profileRepo.save(new UserProfile(user_id));
	}
	
}
