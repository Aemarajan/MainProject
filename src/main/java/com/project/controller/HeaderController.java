package com.project.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.project.service.LevelOneService;
import com.project.service.LevelThreeService;
import com.project.service.LevelTwoService;
import com.project.service.MenuService;
import com.project.service.PrivilegeService;
import com.project.service.UserService;
import com.project.validator.AddLevelOne;
import com.project.validator.AddLevelThree;
import com.project.validator.AddLevelTwo;
import com.project.validator.DeleteLevelOne;
import com.project.validator.DeleteLevelThree;
import com.project.validator.DeleteLevelTwo;

@Controller
public class HeaderController {

	Logger log = LoggerFactory.getLogger(HeaderController.class);
	
	@Autowired
	LevelOneService lvl1ss;

	@Autowired
	LevelTwoService lvl2ss;

	@Autowired
	LevelThreeService lvl3ss;

	@Autowired
	MenuService menuService;

	@Autowired
	PrivilegeService privilegeService;

	@Autowired
	UserService userService;

	@RequestMapping("LevelOneForm")
	public String getLevelOne(HttpSession session,ModelMap model) {
		if (session.getAttribute("id") != null) {
			log.info("user name : "+session.getAttribute("name")+" / user id : "+session.getAttribute("id")+" / Level one form accessed");
			model.addAttribute("levelOne", new AddLevelOne());
			return "LevelOneForm";
		}
		else {
			log.info("Level One Form accessed , but session expired...");
			return "redirect:/logout";
		}
	}

	@RequestMapping("LevelTwoForm")
	public ModelAndView getLevelTwo(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			log.info("session expired");
			return new ModelAndView("redirect:/logout");
		}
		ModelAndView m = new ModelAndView("LevelTwoForm");
		model.addAttribute("levelTwo", new AddLevelTwo());
		log.info("user name : "+session.getAttribute("name")+" / user id : "+session.getAttribute("id")+" / Level two form accessed");
		return m;
	}

	@RequestMapping("LevelThreeForm")
	public ModelAndView getLevelThree(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			log.info("session expired in level three form.");
			log.info("-------------------------------------------------------");
			return new ModelAndView("redirect:/logout");
		}
		ModelAndView m = new ModelAndView("LevelThreeForm");
		log.info("user name : "+session.getAttribute("name"));
		log.info("user id : "+session.getAttribute("id"));
		log.info("Level Three Form Accessed.");
		model.addAttribute("levelThree", new AddLevelThree());
		return m;
	}

	@PostMapping("saveLvl1")
	public ModelAndView saveLevelOne(@Valid @ModelAttribute("levelOne") AddLevelOne levelOne,BindingResult result,Model model,HttpSession session) {
		log.info("user name : "+session.getAttribute("name"));
		log.info("user id : "+session.getAttribute("id"));
		if(result.hasErrors()) {
			log.info("Form error : "+result);
			log.info("-------------------------------------------------------");
			return new ModelAndView("LevelOneForm");
		}
		if (session.getAttribute("id") != null) {
			ModelAndView mv = new ModelAndView("LevelOneForm");
			List<LevelOne> lvl1t = lvl1ss.selectAll();
			for(LevelOne lv1:lvl1t) {
				if(lv1.getName().equalsIgnoreCase(levelOne.getName().toLowerCase())) {
					log.info("Level one - " +levelOne.getName()+" already exist");
					mv.addObject("exist", "already exist");
					log.info("-------------------------------------------------------");
					return mv;
				}
			}
			LevelOne lvl1 = new LevelOne();
			if (levelOne.isDd() == false) {
				lvl1.setName(levelOne.getName());
				lvl1.setDd(levelOne.isDd());
				lvl1ss.saveLevelOne(lvl1);
				Menu m1 = new Menu();
				m1.setLvl1(lvl1);
				m1.setRef(levelOne.getRef());
				menuService.save(m1);
				List<User> userList = userService.selectAllUser();
				for (User u : userList) {
					Privilege p = new Privilege();
					p.setUser(u);
					p.setMenu_id(m1);
					p.setInn(0);
					privilegeService.savePrivilege(p);
				}
				
				log.info("Level one saved with menu.");
				log.info("Level One = "+lvl1.toString());
				log.info("Menu = "+m1.toString());
				log.info("-------------------------------------------------------");
				mv.addObject("added", "success");
			} else {
				lvl1.setName(levelOne.getName());
				lvl1.setDd(levelOne.isDd());
				lvl1ss.saveLevelOne(lvl1);
				log.info("Level one save with menu.");
				log.info("Level One = "+lvl1.toString());
				log.info("-------------------------------------------------------");
				mv.addObject("temp", "failed");
			}
			return mv;
		} else {
			log.info("Session expired in level one form");
			log.info("-------------------------------------------------------");
			return new ModelAndView("redirect:/logout");
		}
	}
	
	@RequestMapping("saveLvl2")
	public ModelAndView saveLevelTwo(@Valid @ModelAttribute("levelTwo") AddLevelTwo levelTwo,BindingResult result,@RequestParam("lvl1")int lvl1f, HttpSession session) {
		log.info("user name : "+session.getAttribute("name"));
		log.info("user id : "+session.getAttribute("id"));
		if(result.hasErrors()) {
			log.info("Form error : "+result);
			return new ModelAndView("LevelTwoForm");
		}
		if(session.getAttribute("id") == null) {
			log.info("Session expired in level two form.");
			return new ModelAndView("redirect:/logout");
		}
		ModelAndView m = new ModelAndView("LevelTwoForm");
		List<LevelTwo> lvl2List = lvl2ss.selectByLevelOneAndDD(lvl1f, 1);
		for(LevelTwo lv2 : lvl2List) {
			if(lv2.getName().equalsIgnoreCase(levelTwo.getName().toLowerCase())) {
				m.addObject("exist", "alredy exist");
				return m;
			}
		}
		if (levelTwo.isDd() == false) {
			LevelOne lvl1 = new LevelOne();
			lvl1.setLvl1_id(lvl1f);
			LevelTwo lvl2 = new LevelTwo();
			lvl2.setLvl1(lvl1);
			lvl2.setName(levelTwo.getName());
			lvl2.setDd(levelTwo.isDd());
			lvl2ss.saveLevelTwo(lvl2);
			Menu m1 = new Menu();
			m1.setLvl1(lvl2.getLvl1());
			m1.setLvl2(lvl2);
			m1.setRef(levelTwo.getRef());
			menuService.save(m1);
			List<User> userList = userService.selectAllUser();
			for (User u : userList) {
				Privilege p = new Privilege();
				p.setUser(u);
				p.setMenu_id(m1);
				p.setInn(0);
				privilegeService.savePrivilege(p);
			}
			m.addObject("added", "success");
		} else {
			LevelOne lvl1 = new LevelOne();
			lvl1.setLvl1_id(lvl1f);
			LevelTwo lvl2 = new LevelTwo();
			lvl2.setLvl1(lvl1);
			lvl2.setName(levelTwo.getName());
			lvl2.setDd(levelTwo.isDd());
			lvl2ss.saveLevelTwo(lvl2);
			m.addObject("temp", "success");
		}

		return m;
	}

	@RequestMapping("saveLvl3")
	public ModelAndView saveLevelThree(@Valid @ModelAttribute("levelThree") AddLevelThree levelThree,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return new ModelAndView("LevelThreeForm");
		}
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		
		ModelAndView m = new ModelAndView("LevelThreeForm");
		List<Menu> exist = new ArrayList<Menu>();
		try {
			exist = menuService.selectByLevelOnTwoThreeId(levelThree.getLvl1(), levelThree.getLvl2(),levelThree.getLvl3());
			if(exist.size() == 1) {
				System.out.println("exist");
				m.addObject("exist", "already exist");
				return m;
			}else {
				LevelOne lvl1 = new LevelOne();
				LevelTwo lvl2 = new LevelTwo();
				LevelThree lvl3 = new LevelThree();
				lvl1.setLvl1_id(levelThree.getLvl1());
				lvl2.setLvl2_id(levelThree.getLvl2());
				lvl3.setLvl3_id(levelThree.getLvl3());
				Menu m1 = new Menu();
				m1.setLvl3(lvl3);
				m1.setLvl1(lvl1);
				m1.setLvl2(lvl2);
				m1.setRef(levelThree.getRef());
				menuService.save(m1);
				List<User> userList = userService.selectAllUser();
				for (User u : userList) {
					Privilege p = new Privilege();
					p.setUser(u);
					p.setMenu_id(m1);
					p.setInn(0);
					privilegeService.savePrivilege(p);
				}
				m.addObject("success", "success");
			}
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		return m;
	}

	@RequestMapping("home")
	public String getHome(HttpSession session) {
		if (session.getAttribute("name") != null)
			return "Home";
		return "redirect:/logout";
	}
	
	@RequestMapping("Gallery")
	public String getGallery(HttpSession session) {
		if(session.getAttribute("id") != null)
			return "Gallery";
		return "redirect:/logout";
	}

	@RequestMapping("show")
	public ModelAndView viewShow(HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("show");
		return m;
	}

	@RequestMapping("DeleteLevelOneForm")
	public ModelAndView getDeleteLevelOneForm(ModelMap model,HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("DeleteLevelOne");
		m.addObject("lvl1", lvl1ss.selectAll());
		model.addAttribute("deleteLevelOne", new DeleteLevelOne());
		return m;
	}

	@RequestMapping("deleteLevelOne")
	public ModelAndView deleteLevelOne(@Valid @ModelAttribute("deleteLevelOne") DeleteLevelOne deleteLevelOne,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			log.info("Form error : "+result);
			return new ModelAndView("DeleteLevelOne");
		}
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("DeleteLevelOne");
		m.addObject("delete", "success");
		lvl1ss.deleteById(deleteLevelOne.getLvl1());
		return m;
	}

	@RequestMapping("DeleteLevelTwo")
	public ModelAndView getDeleteLevelTwo(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView();
		List<LevelOne> lvl1 = lvl1ss.selectByDd(1);
		m.addObject("lvl1i", lvl1);
		model.addAttribute("deleteLevelTwo", new DeleteLevelTwo());
		return m;
	}

	@RequestMapping("deleteLevelTwo")
	public ModelAndView deleteLevelTwo(@Valid @ModelAttribute("deleteLevelTwo") DeleteLevelTwo deleteLevelTwo,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return new ModelAndView("DeleteLevelTwo");
		}
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("DeleteLevelTwo");
		m.addObject("delete", "success");
		lvl2ss.deleteById(deleteLevelTwo.getLvl2());
		return m;
	}

	@RequestMapping("DeleteLevelThree")
	public ModelAndView getDeleteLevelThree(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("DeleteLevelThree");
		m.addObject("lvl1i", lvl1ss.selectByDd(1));
		model.addAttribute("deleteLevelThree", new DeleteLevelThree());
		return m;
	}

	@RequestMapping("deleteLevelThree")
	public ModelAndView deleteLevelThee(@Valid DeleteLevelThree levelThree,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return new ModelAndView("DeleteLevelThree");
		}
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("DeleteLevelThree");
		m.addObject("delete", "success");
		menuService.deleteByLevelId(levelThree.getLvl1(), levelThree.getLvl2(), levelThree.getLvl3());
		return m;
	}
	
	@RequestMapping("header")
	public ModelAndView getHeader(HttpSession session) {
		if(session.getAttribute("id") == null)
			return new ModelAndView("redirect:/logout");
		ModelAndView m = new ModelAndView("Menubar");
		List<Menu> menuList = new ArrayList<Menu>();
		List<LevelOne> lvl1p = new ArrayList<LevelOne>();
		List<LevelTwo> lvl2p = new ArrayList<LevelTwo>();
		List<Privilege> listPri = privilegeService.selectByUserIdAndInn((int)(session.getAttribute("id")), 1);
		Set<LevelOne> lvl1set = new HashSet<LevelOne>();
		Set<LevelTwo> lvl2set = new HashSet<LevelTwo>();
		for(Privilege p : listPri) {
			menuList.add(p.getMenu_id());
			lvl1set.add(p.getMenu_id().getLvl1());
			if(p.getMenu_id().getLvl2() == null)
				continue;
			else
				lvl2set.add(p.getMenu_id().getLvl2());
		}
		List<LevelOne> lvl1t = lvl1ss.selectAll();
		for(LevelOne l1 : lvl1t) {
			for(LevelOne lv1 :lvl1set) {
				if(l1.getLvl1_id() == lv1.getLvl1_id())
					lvl1p.add(l1);
			}
		}
		List<LevelTwo> lvl2t = lvl2ss.selectAll();
		for(LevelTwo l2 : lvl2t) {
			for(LevelTwo lv2 : lvl2set) {
				if(l2.getLvl2_id() == lv2.getLvl2_id())
					lvl2p.add(l2);
			}
		}
		m.addObject("menu", menuList);
		m.addObject("lvl1", lvl1p);
		m.addObject("lvl2", lvl2p);
		m.addObject("lvl3", lvl3ss.selectAll());
		return m;
	}
	
}
