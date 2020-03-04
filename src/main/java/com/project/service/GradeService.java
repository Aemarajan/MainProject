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
	
	@Autowired
	RegulationService regulationService;

	public void saveGradeMaster(int regulation,String word,String acronym,int point,String marks_range,boolean inn) {
		Grade g = new Grade(regulationService.selectById(regulation),word,acronym,point,marks_range,inn?1:0);
		gdrepo.save(g);
	}
	
	public List<Grade> selectAll(){
		List<Grade> list = gdrepo.findAll();
		return list;
	}
	
	public void update(int id, String word, String acronym,int point,String marks_range, Integer regulation, boolean inn) {
		gdrepo.update(id,word,acronym,point,marks_range,regulationService.selectById(regulation),inn?1:0);
	}

	public void updateInnZero(int id, int i) {
		gdrepo.updateInnZero(id,i);
	}
	
	public List<Grade> selectAllExceptId(int id) {
		return gdrepo.findAllExceptId(id);
	}
}
