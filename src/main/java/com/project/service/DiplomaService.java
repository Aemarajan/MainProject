package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Diploma;
import com.project.repository.DiplomaRepository;

@Service
public class DiplomaService {

	@Autowired
	DiplomaRepository dmrepo;

	public void saveDiplomaMaster(Diploma dm) {
		dmrepo.save(dm);
	}
	
	public List<Diploma> selectAll(){
		List<Diploma> list = dmrepo.findAll();
		return list;
	}
}
