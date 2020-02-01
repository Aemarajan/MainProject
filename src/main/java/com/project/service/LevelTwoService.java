package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.LevelTwo;
import com.project.repository.LevelTwoRepository;

@Service
public class LevelTwoService {

	@Autowired
	LevelTwoRepository lvl2Repo;
	
	public void saveLevelTwo(LevelTwo lvl2) {
		lvl2Repo.save(lvl2);
	}
	
	public List<LevelTwo> selectByDd(int dd) {
		List<LevelTwo> list = lvl2Repo.selectByDdOne(dd);
		return list;
	}
	
	public List<LevelTwo> selectById(int id){
		List<LevelTwo> list = lvl2Repo.selectByLvl1id(id);
		return list;
	}

	public List<LevelTwo> selectAll() {
		List<LevelTwo> list = lvl2Repo.findAll();
		return list;
	}

	public void deleteById(int lvl2_id) {
		lvl2Repo.deleteById(lvl2_id);
	}

	public List<LevelTwo> selectByLevelOneAndDD(int id, int i) {
		List<LevelTwo> list = lvl2Repo.selectByLevelOneAndDd(id,i);
		return list;
	}

}
