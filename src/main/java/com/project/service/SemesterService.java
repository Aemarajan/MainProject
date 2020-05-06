package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Semester;
import com.project.repository.SemesterRepository;

@Service
public class SemesterService {

	@Autowired
	SemesterRepository semrepo;
	
	@Autowired
	DepartmentService departmentService;
	
	public List<Semester> selectAll(){
		List<Semester> list = semrepo.findAll();
		return list;
	}
	
	public void saveSemesterMaster(String name, boolean inn) {
		Semester sem = new Semester(name,inn?1:0);
		semrepo.save(sem);
	}

	public void update(int id, String name, boolean inn) {
		semrepo.update(id,name,inn?1:0);
	}

	public List<Semester> selectAllExceptId(int id) {
		return semrepo.findAllExceptId(id);
	}

	public void updateInnZero(int id, int i) {
		semrepo.updateInnZero(id,i);
	}

	public Semester selectById(int id) {
		List<Semester> list = semrepo.findAll();
		for(Semester s : list) {
			if(id == s.getId())
				return s;
		}
		return null;
	}

}
