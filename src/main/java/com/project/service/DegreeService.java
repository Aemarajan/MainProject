package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Degree;
import com.project.repository.DegreeRepository;

@Service
public class DegreeService {

	@Autowired
	DegreeRepository dgrepo;

	public void saveDegreeMaster(String name,String acronym,boolean inn) {
		Degree degree = new Degree(name,acronym,inn?1:0);
		dgrepo.save(degree);
	}
	
	public List<Degree> selectAll(){
		List<Degree> list = dgrepo.findAll();
		return list;
	}	
}
