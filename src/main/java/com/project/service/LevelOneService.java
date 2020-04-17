package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.LevelOne;
import com.project.repository.LevelOneRepository;

@Service
public class LevelOneService {

	@Autowired
	LevelOneRepository lvlRepo;
	
	public void saveLevelOne(LevelOne lvl1) {
		lvlRepo.save(lvl1);
	}

	public List<LevelOne> selectByDd(int dd) {
		List<LevelOne> list = lvlRepo.selectByDdOne(dd);
		return list;
	}
	
	public List<LevelOne> selectAll(){
		List<LevelOne> list = lvlRepo.findAll();
		return list;
	}
	
	public void deleteById(int lvl1_id) {
		lvlRepo.deleteById(lvl1_id);
	}

	public List<LevelOne> selectAllExceptId(int lvl1_id) {
		return lvlRepo.findAllById(lvl1_id);
	}

	public void updateLevelOne(int lvl1_id, String name, int dd, int i) {
		lvlRepo.update(lvl1_id, name, dd, i);
	}
	
}
