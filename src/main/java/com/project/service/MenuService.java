package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Menu;
import com.project.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepo;
	
	public void save(Menu menu) {
		menuRepo.save(menu);
	}

	public List<Menu> selectAll() {
		List<Menu> list = menuRepo.findAll();
		return list;
	}
	
	public List<Menu> selectByLevelOneAndLevelTwoId(int lvl1,int lvl2){
		List<Menu> list = menuRepo.selectByOneAndTwoId(lvl1,lvl2);
		return list;
	}

	public void deleteByLevelId(int lvl1_id, int lvl2_id, int lvl3_id) {
		menuRepo.deleteByLevel(lvl1_id,lvl2_id,lvl3_id);
	}
	
	public int count() {
		return (int) menuRepo.count();
	}

	public List<Menu> selectByLevelOneAndLevelTwo(int lvl1,int lvl2) {
		List<Menu> list = menuRepo.selectByOneAndTwoId(lvl1, lvl2);
		return list;
	}

	public List<Menu> selectByLevelOnTwoThreeId(int lvl1, int lvl2,int lvl3) {
		return menuRepo.selectByOneTwoThree(lvl1, lvl2, lvl3);
	}
	
}
