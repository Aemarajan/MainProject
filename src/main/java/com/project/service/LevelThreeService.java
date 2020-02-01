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
	
}
