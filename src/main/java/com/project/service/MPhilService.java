package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MPhil;
import com.project.repository.MPhilRepository;

@Service
public class MPhilService {

	@Autowired
	MPhilRepository mprepo;

	public void saveMPhilMaster(MPhil mp) {
		mprepo.save(mp);
	}
	
	public List<MPhil> selectAll(){
		List<MPhil> list = mprepo.findAll();
		return list;
	}
}
