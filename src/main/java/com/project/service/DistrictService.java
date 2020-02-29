package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.District;
import com.project.model.State;
import com.project.repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	DistrictRepository disrepo;
	
	@Autowired
	StateService stateService;

	public List<District> selectAll(){
		List<District> list = disrepo.findAll();
		return list;
	}

	public void saveDistrictMaster(String name, String acronym, Integer state, int i) {
		District district = new District(name,acronym,stateService.selectById((int) state),i);
		disrepo.save(district);
	}

	public void updateInnZero(int id, int i) {
		disrepo.updateInn(id,i);
	}

	public void update(int id, String name, String acronym, State state, int i) {
		disrepo.update(name, acronym, state, i, id);
	}	
	
	public List<District> selectAllExceptId(int id){
		return disrepo.findAllExceptId(id);
	}
}
