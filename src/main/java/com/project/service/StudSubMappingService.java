package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.StudSubMapping;
import com.project.repository.StudSubMappingRepository;

@Service
public class StudSubMappingService {

	@Autowired
	StudSubMappingRepository ssmRepo;
	
	public List<StudSubMapping> selectAll() {
		return ssmRepo.findAll();
	}

	public void save(StudSubMapping ssm) {		
		ssmRepo.save(ssm);
	}

	public StudSubMapping selectById(int id) {
		List<StudSubMapping> list = ssmRepo.findAll();
		for(StudSubMapping ssm:list) {
			if(ssm.getId() == id)
				return ssm;
		}
		return null;
	}

	public void updateInn(int id, int i) {
		ssmRepo.updateInn(id,i);
	}

	public List<StudSubMapping> selectAllSubjectsByUserId(int user, int sem) {
		return ssmRepo.selectAllSubjectsByUserId(user,sem);
	}
}
