package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Department;
import com.project.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository  dpmrepo;
	
	@Autowired
	DegreeService degreeService;

	public List<Department> selectAll(){
		List<Department> list = dpmrepo.findAll();
		return list;
	}

	public Department selectById(Integer degree) {
		List<Department> list = dpmrepo.findAll();
		for(Department d : list) {
			if(d.getId() == degree) {
				return d;
			}
		}
		return null;
	}
	
	public void saveDepartmentMaster(String name, String acronym, int degree, boolean inn) {
		Department dept = new Department(name,acronym,degreeService.selectById(degree),inn?1:0);
		dpmrepo.save(dept);
	}

	public void update(int id, String name, String acronym, Integer degree, boolean inn) {
		dpmrepo.update(id,name,acronym,degreeService.selectById(degree),inn?1:0);
	}

	public List<Department> selectAllExceptId(int id) {
		return dpmrepo.findAllExceptId(id);
	}

	public void updateInnZero(int id, int i) {
		dpmrepo.updateInnZero(id,i);
	}
	
}