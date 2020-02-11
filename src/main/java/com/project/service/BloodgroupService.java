package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Bloodgroup;
import com.project.repository.BloodgroupRepository;

@Service
public class BloodgroupService {

	@Autowired
	BloodgroupRepository bgmrepo;
	
	public void saveBloodgroupMaster(Bloodgroup bgm) {
		bgmrepo.save(bgm);
	}
	
	public List<Bloodgroup> selectAll(){
		List<Bloodgroup> list = bgmrepo.findAll();
		return list;
	}

	public List<Bloodgroup> selectByName(String name) {
		List<Bloodgroup> list = bgmrepo.selectByName(name);
		return list;
	}
	
}
