package com.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;
	
	public void updatePersonal(Date dob, int blood, int religion, int community, int id) {
		profileRepo.updatePersonal(dob,blood,religion,community,id);
	}
	
}
