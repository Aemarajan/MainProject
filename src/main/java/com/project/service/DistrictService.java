package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.District;
import com.project.repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	DistrictRepository disrepo;

	public void saveDistrictMaster(District ds) {
		disrepo.save(ds);
	}
	
	public List<District> selectAll(){
		List<District> list = disrepo.findAll();
		return list;
	}	
}
