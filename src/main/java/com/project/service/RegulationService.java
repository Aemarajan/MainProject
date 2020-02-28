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

	public List<Regulation> selectAll(){
		List<Regulation> list = rgrepo.findAll();
		return list;
	}

	public void saveRegulationMaster(String name, String acronym, boolean inn) {
		Regulation r = new Regulation(name,acronym,inn?1:0);
		rgrepo.save(r);
	}
	
	public void update(int id, String name, String acronym, boolean inn) {
		rgrepo.update(id,name,acronym,inn?1:0);
	}

	public List<Regulation> selectAllExceptId(int id) {
		return rgrepo.findAllExceptId(id);
	}

	public void updateInnZero(int id, int i) {
		rgrepo.updateInnZero(id,i);
	}
}
