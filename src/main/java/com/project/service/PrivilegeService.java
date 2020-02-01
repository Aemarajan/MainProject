package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Privilege;
import com.project.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

	@Autowired
	PrivilegeRepository pRepo;
	
	public void savePrivilege(Privilege privilege) {
		pRepo.save(privilege);
	}
	
	public List<Privilege> selectByUserIdAndInn(int id,int inn){
		return pRepo.findByUserId(id,inn);
	}
	
	public List<Privilege> selectByUserId(int id){
		return pRepo.findAllByUser(id);
	}
	
	public void updatePrivilege(int user_id,int menu_id,int inn) {
		pRepo.update(user_id, menu_id, inn);
	}
	
}
