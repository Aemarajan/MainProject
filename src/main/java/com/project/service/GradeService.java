package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Grade;
import com.project.repository.GradeRepository;

@Service
public class GradeService {

	@Autowired
	GradeRepository gdrepo;

	public void saveGradeMaster(Grade gd) {
		gdrepo.save(gd);
	}
	
	public List<Grade> selectAll(){
		List<Grade> list = gdrepo.findAll();
		return list;
	}
	
	
}
