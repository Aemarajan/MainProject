package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Schooling;
import com.project.repository.SchoolingRepository;

@Service
public class SchoolingService {

	@Autowired
	SchoolingRepository schoolRepo;

	public void createSchoolProfile(int user_id, String course) {
		schoolRepo.save((Schooling) new Schooling(user_id,course));
	}
	
	
	
}
