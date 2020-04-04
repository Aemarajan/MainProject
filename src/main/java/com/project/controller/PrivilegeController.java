package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.AddPrivilege;
import com.project.customvalidator.ModifyPrivilege;
import com.project.model.LevelOne;
import com.project.model.LevelThree;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.Privilege;
import com.project.model.User;
import com.project.service.LevelOneService;
import com.project.service.LevelThreeService;
import com.project.service.LevelTwoService;
import com.project.service.MenuService;
import com.project.service.PrivilegeService;
import com.project.service.UserService;

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
	public ModelAndView getPrivilegeForm(HttpSession session,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "error", required = false) String error) {
		ModelAndView m = new ModelAndView();
		if (session.getAttribute("id") == null) {
			m.setViewName("redirect:/logout");
			m.addObject("session", "error");
			return m;
		}
		if (!(added == null))
			m.addObject("added", "success");
		if (!(error == null))
			m.addObject("error", "error");

		m.setViewName("AddPrivilege");
		m.addObject("addPrivilege", new AddPrivilege());

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
	public ModelAndView createPrivilege(@Valid @ModelAttribute("addPrivilege") AddPrivilege addPrivilege,
			BindingResult result, @RequestParam(value = "menu_id", required = false) int[] check,
			@RequestParam("id") int id, HttpSession session) {

		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("AddPrivilege");

			List<LevelOne> levelOneList = lvl1ss.selectAll();
			List<LevelTwo> levelTwoList = lvl2ss.selectAll();
			List<LevelThree> levelThreeList = lvl3ss.selectAll();
			List<Menu> menuList = menuService.selectAll();
			List<User> userList = userService.selectByPp(0);

			mv.addObject("lvl1", levelOneList);
			mv.addObject("lvl2", levelTwoList);
			mv.addObject("lvl3", levelThreeList);
			mv.addObject("menu", menuList);
			mv.addObject("user", userList);
			return mv;
		}
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
				} else {
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
			userService.updatePrivilegeProvide(id, 1);
			mv.setViewName("redirect:/AddPrivilege");
			mv.addObject("added", "added");
		} catch (NullPointerException e) {
			mv.setViewName("redirect:/AddPrivilege");
			mv.addObject("error", "error");
			return mv;
		}
		return mv;
	}

	boolean is(int i, int arr[]) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i)
				return true;
		}
		return false;
	}

	@GetMapping("ModifyPrivilege")
	public ModelAndView updatePrivilegeForm(HttpSession session,
			@RequestParam(value = "updated", required = false) String updated,
			@RequestParam(value = "error", required = false) String error) {
		ModelAndView m = new ModelAndView();
		if (session.getAttribute("id") == null) {
			m.setViewName("redirect:/logout");
			m.addObject("session", "destroy");
			return m;
		}
		if (!(updated == null))
			m.addObject("updated", "success");
		if (!(error == null))
			m.addObject("error", "error");

		m.setViewName("ModifyPrivilege");
		m.addObject("modifyPrivilege", new ModifyPrivilege());
		return m;
	}

	@PostMapping("getUserPrivilege")
	public ModelAndView getUserPrivilege(@Valid @ModelAttribute("modifyPrivilege") ModifyPrivilege modifyPrivilege,
			BindingResult result, User user, HttpSession session) {

		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("ModifyPrivilege");
			return mv;
		}
		mv.setViewName("UpdatePrivilege");
		mv.addObject("pri", privilegeService.selectByUserId(user.getUser_id()));
		mv.addObject("user", userService.findById(user.getUser_id()));
		mv.addObject("menu", menuService.selectAll());
		mv.addObject("lvl1", lvl1ss.selectAll());
		mv.addObject("lvl2", lvl2ss.selectAll());
		mv.addObject("lvl3", lvl3ss.selectAll());
		return mv;
	}

	@PostMapping("UpdatePrivilege")
	public ModelAndView updatePrivilege(HttpSession session, @RequestParam int user_id,
			@RequestParam(value = "menu_id", required = false) int[] check) {
		if (session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView();
		try {
			List<Menu> menuList = menuService.selectAll();
			int menuid[] = new int[menuList.size()];
			int c = 0;
			for (Menu menu : menuList) {
				menuid[c] = menu.getMenu_id();
				c += 1;
			}
			for (int i : menuid) {
				boolean b = is(i, check);
				if (b) {
					privilegeService.updatePrivilege(user_id, i, 1);
				} else {
					privilegeService.updatePrivilege(user_id, i, 0);
				}
			}
		} catch (NullPointerException e) {
			m.setViewName("redirect:/ModifyPrivilege");
			m.addObject("error", "Error");
			return m;
		}
		m.setViewName("redirect:/ModifyPrivilege");
		m.addObject("updated", "success");
		return m;
	}
}