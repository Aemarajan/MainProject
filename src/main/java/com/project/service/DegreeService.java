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

	public void saveDegreeMaster(String category, String name,String acronym,boolean inn) {
		Degree degree = new Degree(category,name,acronym,inn?1:0);
		dgrepo.save(degree);
	}
	
	public List<Degree> selectAll(){
		List<Degree> list = dgrepo.findAll();
		return list;
	}

	public void updateDegree(int id,String name, String acronym, int inn) {
		dgrepo.updateDegree(id,name,acronym,inn);
		
	}
	
	public void updateInnZero(int id) {
		dgrepo.updateDegree(id,0);
	}

	public List<Degree> selectAllExceptId(int id) {
		return dgrepo.findAllExceptId(id);
	}

	public Degree selectById(Integer degree) {
		List<Degree> list = dgrepo.findAll();
		for(Degree d : list) {
			if(d.getId() == degree) {
				return d;
			}
		}
		return null;
	}
	
}
