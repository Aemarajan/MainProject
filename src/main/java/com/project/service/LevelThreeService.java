package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.LevelThree;
import com.project.repository.LevelThreeRepository;

@Service
public class LevelThreeService {

	@Autowired
	LevelThreeRepository lvl3Repo;
	
	public void saveLevelThree(LevelThree lvl3) {
		lvl3Repo.save(lvl3);
	}
	
	public List<LevelThree> selectAll(){
		List<LevelThree> list = lvl3Repo.findAll();
		return list;
	}
	
	public void updateLevelThree(int lvl3_id, String name, int i) {
		lvl3Repo.update(lvl3_id, name, i);
	}
	
	public List<LevelThree> selectAllExceptId(int lvl3_id) {
		return lvl3Repo.findAllById(lvl3_id);
	}
}
