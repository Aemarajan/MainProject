package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.GraduateRepository;

@Service
public class GraduateService {

	@Autowired
	GraduateRepository graduateRepo;
	
	
}
