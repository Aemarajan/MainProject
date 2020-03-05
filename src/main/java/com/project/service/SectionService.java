package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Section;
import com.project.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepo;
	
	public List<Section> selectAll(){
		return sectionRepo.findAll();
	}
	
	public Section selectById(int id) {
		List<Section> list = sectionRepo.findAll();
		for(Section s : list) {
			if(s.getId() == id)
				return s;
		}
		return null;
	}

	public void save(String name, boolean inn) {
		Section section = new Section(name,inn?1:0); 
		sectionRepo.save(section);
	}

	public void updateInnZero(int id, int i) {
		sectionRepo.updateInn(id,i);
	}

	public List<Section> selectAllExceptId(int id) {
		return sectionRepo.findAllExceptId(id);
	}

	
}
