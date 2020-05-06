package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Syllabus;
import com.project.repository.SyllabusRepository;

@Service
public class SyllabusService {

	@Autowired
	SyllabusRepository sylRepo;
	
	public List<Syllabus> selectAll(){
		return sylRepo.findAll();
	}
	
	public Syllabus selectById(int id) {
		List<Syllabus> list = sylRepo.findAll();
		for(Syllabus s : list) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	public List<Syllabus> selectAllExceptId(int id){
		return sylRepo.findAllExceptId(id);
	}

	public void save(String code, String name, String category, int contact_period, int lecture, int tutorial, int practical, int credit,int inn) {
		Syllabus s = new Syllabus(code,name,category,contact_period,lecture,tutorial,practical,credit,inn);
		sylRepo.save(s);
	}

	public void update(int id, String name, String code, String category, int contact_period, int lecture, int tutorial, int practical, int credit, boolean inn) {
		sylRepo.update(id,name,code,category,contact_period,lecture,tutorial,practical,credit,inn?1:0);
	}

	public void updateInnZero(int id, int i) {
		sylRepo.updateInn(id, i);
	}
	
	
}
