package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.LevelOne;
import com.project.model.LevelThree;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.User;
import com.project.service.LevelOneService;
import com.project.service.LevelThreeService;
import com.project.service.LevelTwoService;
import com.project.service.MenuService;
import com.project.service.PrivilegeService;
import com.project.service.UserService;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	LevelTwoService lvl2s;
	
	@Autowired
	LevelOneService lvl1s;
	
	@Autowired
	LevelThreeService lvl3s;
	
	@Autowired
	PrivilegeService privilegeService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/getAllLevelOneByDd")
	public List<LevelOne> getAllLevelOneByDd(){
		return lvl1s.selectByDd(1);
	}
	
	@RequestMapping("/getAllLevelOne")
	public List<LevelOne> getAllLevelOne(){
		return lvl1s.selectAll();
	}
	
	@RequestMapping("/getAllLevelThree")
	public List<LevelThree> getAllLevelThree(){
		return lvl3s.selectAll();
	}
	
	@RequestMapping("/getLvl2/{id}")
	public List<LevelTwo> getLevelTwoById(@PathVariable("id") int id){
		List<LevelTwo> list = lvl2s.selectById(id);
		return list;
	}
	
	@RequestMapping("/getLevelThree/{lvl1}/{lvl2}")
	public List<Menu> getLevelThree(@PathVariable("lvl1") int lvl1,@PathVariable("lvl2") int lvl2){
		List<Menu> list = menuService.selectByLevelOneAndLevelTwoId(lvl1, lvl2);
		return list;
	}
	
	@RequestMapping("/getLvl2DD/{id}")
	public List<LevelTwo> getLevelTwoByDd(@PathVariable("id") int id){
		List<LevelTwo> list = lvl2s.selectByLevelOneAndDD(id, 1);
		return list;
	}
	
	@RequestMapping("/getUserPp1")
	public List<User> getUser(){
		List<User> list = userService.selectByPp(1);
		return list;
	}
	
	@RequestMapping("/getUserPp0")
	public List<User> getUserPpZero(){
		List<User> list = userService.selectByPp(0);
		return list;
	}
	
}