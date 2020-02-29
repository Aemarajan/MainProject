package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LevelOne;
import com.project.model.LevelThree;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.Privilege;
import com.project.model.User;
import com.project.service.*;

@Controller
public class PrivilegeController {

	@Autowired
	LevelOneService lvl1ss;

	@Autowired
	LevelTwoService lvl2ss;

	@Autowired
	LevelThreeService lvl3ss;

	@Autowired
	MenuService menuService;

	@Autowired
	UserService userService;

	@Autowired
	PrivilegeService privilegeService;
	
	@RequestMapping("AddPrivilege")
	public ModelAndView getPrivilegeForm(@RequestParam(value="added",required=false)String added,@RequestParam(value="error",required=false)String error,HttpSession session) {
		ModelAndView m = new ModelAndView();
		if(session.getAttribute("id") == null) {
			m.setViewName("redirect:/logout");
			m.addObject("session", "error");
		return m;
		}	
		
		m.setViewName("AddPrivilege");
		if(!(added == null))
			m.addObject("added", "success");
		if(!(error == null))
			m.addObject("error", "error");
	
		List<LevelOne> levelOneList = lvl1ss.selectAll();
		List<LevelTwo> levelTwoList = lvl2ss.selectAll();
		List<LevelThree> levelThreeList = lvl3ss.selectAll();
		List<Menu> menuList = menuService.selectAll();
		List<User> userList = userService.selectByPp(0);
		m.addObject("lvl1", levelOneList);
		m.addObject("lvl2", levelTwoList);
		m.addObject("lvl3", levelThreeList);
		m.addObject("menu", menuList);
		m.addObject("user", userList);
	return m;
	}

	@PostMapping("createPrivilege")
	public ModelAndView createPrivilege(@RequestParam(value = "menu_id", required = false) int[] check,@RequestParam("id") int id,HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView();
		List<Menu> menuList = menuService.selectAll();
		try {
			int menuId[] = new int[menuList.size()];
			int c = 0;
			for (Menu menu : menuList) {
				menuId[c] = menu.getMenu_id();
				c += 1;
			}
			for (int i : menuId) {
				boolean b = is(i, check);
				if (b) {
					Menu me = new Menu();
					me.setMenu_id(i);
					User user = new User();
					user.setUser_id(id);
					Privilege p = new Privilege();
					p.setMenu_id(me);
					p.setUser(user);
					p.setInn(1);
					privilegeService.savePrivilege(p);
				}
				else {
					Menu me = new Menu();
					me.setMenu_id(i);
					User user = new User();
					user.setUser_id(id);
					Privilege p = new Privilege();
					p.setMenu_id(me);
					p.setUser(user);
					p.setInn(0);
					privilegeService.savePrivilege(p);
				}
			}
			userService.updatePrivilegeProvide(id,1);
			m.setViewName("redirect:/AddPrivilege");
			m.addObject("added","added");
		} catch (NullPointerException e) {
			m.setViewName("redirect:/AddPrivilege");
			m.addObject("error", "error");
			return m;
		}
		return m;
	}

	boolean is(int i, int arr[]) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i)
				return true;
		}
		return false;
	}
	
	@RequestMapping("ModifyPrivilege")
	public ModelAndView updatePrivilegeForm(@RequestParam(value="added",required=false)String added,@RequestParam(value="error",required=false)String error, HttpSession session) {
		ModelAndView m = new ModelAndView();
		if(session.getAttribute("id") == null) {
			m.setViewName("redirect:/logout");
			m.addObject("session", "destroy");
			return m;
		}
		if(!(added == null))
			m.addObject("added", "success");
		if(!(error == null))
			m.addObject("error", "error");
		
		m.setViewName("UpdatePrivilege");
		return m;
	}
	
	@RequestMapping("getUserPrivilege")
	public ModelAndView getUserPrivilege(User user,HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView model = new ModelAndView();
		model.setViewName("ModifyPrivilege");
		model.addObject("pri", privilegeService.selectByUserId(user.getUser_id()));
		model.addObject("user", userService.findById(user.getUser_id()));
		model.addObject("menu", menuService.selectAll());
		model.addObject("lvl1", lvl1ss.selectAll());
		model.addObject("lvl2", lvl2ss.selectAll());
		model.addObject("lvl3", lvl3ss.selectAll());
		return model;
	}
	
	@RequestMapping("UpdatePrivilege")
	public ModelAndView updatePrivilege(@RequestParam int user_id,@RequestParam(value="menu_id",required=false) int[] check,HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView();
		try {
		List<Menu> menuList = menuService.selectAll();
		int menuid[] = new int[menuList.size()];
		int c=0;
		for(Menu menu : menuList) {
			menuid[c] = menu.getMenu_id();
			c+=1;
		}
		for(int i:menuid) {
			boolean b = is(i,check);
			if(b) {
				privilegeService.updatePrivilege(user_id, i, 1);
			}else {
				privilegeService.updatePrivilege(user_id, i, 0);
			}
		}
		}catch(NullPointerException e) {
			m.setViewName("redirect:/ModifyPrivilege");
			m.addObject("error", "failure");
			return m;
		}
		m.setViewName("redirect:/ModifyPrivilege");
		m.addObject("added", "success");
		return m;
	}
	
}
