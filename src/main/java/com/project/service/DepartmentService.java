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

	public void saveDepartmentMaster(Department dpm) {
		dpmrepo.save(dpm);
	}
	
	public List<Department> selesctAll(){
		List<Department> list = dpmrepo.findAll();
		return list;
	}
	
}