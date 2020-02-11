package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.PG;
import com.project.repository.PGRepository;

@Service
public class PGService {

	@Autowired
	PGRepository pgrepo;

	public void savePGMaster(PG pg) {
		pgrepo.save(pg);	
	}
	
	public List<PG> selectAll(){
		List<PG> list = pgrepo.findAll();
		return list;
	}
	
}
