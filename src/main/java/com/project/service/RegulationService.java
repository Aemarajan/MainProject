package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Regulation;
import com.project.repository.RegulationRepository;

@Service
public class RegulationService {

	@Autowired
	RegulationRepository rgrepo;

	public void saveRegulationMaster(Regulation rg) {
		rgrepo.save(rg);
	}
	
	public List<Regulation> selectAll(){
		List<Regulation> list = rgrepo.findAll();
		return list;
	}
	
}
