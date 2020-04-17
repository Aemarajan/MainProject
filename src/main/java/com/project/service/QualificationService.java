package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Qualification;
import com.project.repository.QualificationRepository;

@Service
public class QualificationService {

	@Autowired
	QualificationRepository quaRepo;

	public void createUserQualification(int user_id) {
		quaRepo.save(new Qualification(user_id));
	}
	
	
	
}
