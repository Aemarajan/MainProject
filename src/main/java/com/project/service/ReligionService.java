package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Religion;
import com.project.repository.ReligionRepository;

@Service
public class ReligionService {

	@Autowired
	ReligionRepository rgrepo;

	public void saveReligionMaster(Religion rg) {
		rgrepo.save(rg);
	}
	
	public List<Religion> selectAll(){
		List<Religion> list = rgrepo.findAll();
		return list;
	}
}
