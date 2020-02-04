package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Community;
import com.project.repository.CommunityRepository;

@Service
public class CommunityService {

	@Autowired
	CommunityRepository cmrepo;
	
	public void saveCommunityMaster(Community cm) {
		cmrepo.save(cm);
	}
	
	public List<Community> selectAll(){
		List<Community> list = cmrepo.findAll();
		return list;
	}

	public List<Community> selectByAcronym(String acronym) {
		List<Community> list = cmrepo.findByAcronym(acronym);
		return list;
	}
	
	public List<Community> selectByCommunity(String country){
		return cmrepo.findByName(country);
	}
}
