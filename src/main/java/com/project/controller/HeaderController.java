package com.project.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.AddLevelOne;
import com.project.customvalidator.AddLevelThree;
import com.project.customvalidator.AddLevelTwo;
import com.project.customvalidator.DeleteLevelOne;
import com.project.customvalidator.DeleteLevelThree;
import com.project.customvalidator.DeleteLevelTwo;
import com.project.customvalidator.LevelOneValidation;
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
public class HeaderController {

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
	
	@Autowired
	MasterController masterController;
	
	@RequestMapping("header")
	public ModelAndView getHeader(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
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
		mv.setViewName("Menubar");
		mv.addObject("menu", menuList);
		mv.addObject("lvl1", lvl1p);
		mv.addObject("lvl2", lvl2p);
		mv.addObject("lvl3", lvl3ss.selectAll());
		return mv;
	}
	
	@GetMapping("LevelOneForm")
	public ModelAndView addLevelOne(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
		return mv;
		}
		
		mv.setViewName("LevelOneForm");
		mv.addObject("levelOne", new AddLevelOne());
		return mv;
	}

	@PostMapping("saveLvl1")
	public ModelAndView saveLevelOne(@Valid @ModelAttribute("levelOne") AddLevelOne levelOne,BindingResult result,Model model,HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("LevelOneForm");
			return mv;
		}

		mv.setViewName("LevelOneForm");
		List<LevelOne> lvl1t = lvl1ss.selectAll();
		for (LevelOne lv1 : lvl1t) {
			if (lv1.getName().equalsIgnoreCase(levelOne.getName().toLowerCase())) {
				mv.addObject("exist", "already exist");
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
			mv.addObject("added", "success");
		} else {
			lvl1.setName(levelOne.getName());
			lvl1.setDd(levelOne.isDd());
			lvl1ss.saveLevelOne(lvl1);
			mv.addObject("temp", "failed");
		}
		return mv;
	}
	
	@GetMapping("ViewLevelOne")
	public ModelAndView viewLevelOne(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "updated", required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(updated == null)) 
			mv.addObject("updated", "Success");
		
		mv.setViewName("ViewLevelOne");
		mv.addObject("pagedListHolder", masterController.pagination(lvl1ss.selectAll(),request));
		mv.addObject("ValidateLevelOne", new LevelOneValidation());
		return mv;
	}
	
	@PostMapping("EditLevelOne")
	public ModelAndView editLevelOne(@Valid @ModelAttribute("ValidateLevelOne") LevelOneValidation lvl, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("ViewLeveOne");
			mv.addObject("editError", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(lvl1ss.selectAll(),request));
			return mv;
		}
		
		List<LevelOne> list = lvl1ss.selectAllExceptId(lvl.getLvl1_id());
		
		for(LevelOne l : list) {
			if(l.getName().replaceAll("//s", "").equalsIgnoreCase(lvl.getName().replaceAll("//s", ""))) {
				mv.setViewName("ViewLevelOne");
				mv.addObject("editError", "Error");
				mv.addObject("editExist", "Error");
				mv.addObject("pagedListHolder", masterController.pagination(lvl1ss.selectAll(),request));
				return mv;
			}
		}
		
		lvl1ss.updateLevelOne(lvl.getLvl1_id(),lvl.getName(),lvl.getDd(),lvl.isInn() ? 1 : 0);
		
		mv.setViewName("ViewLevelOne");
		mv.addObject("pagedListHolder", masterController.pagination(lvl1ss.selectAll(),request));
		mv.addObject("updated", "Success");
		return mv;
	}
	
	@GetMapping("LevelTwoForm")
	public ModelAndView addLevelTwo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
		return mv;
		}
		
		mv.setViewName("LevelTwoForm");
		mv.addObject("levelTwo", new AddLevelTwo());
		return mv;
	}

	@PostMapping("saveLvl2")
	public ModelAndView saveLevelTwo(@Valid @ModelAttribute("levelTwo") AddLevelTwo levelTwo,BindingResult result,@RequestParam("lvl1")int lvl1f, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
	
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("LevelTwoForm");
			return mv;
		}

		mv.setViewName("LevelTwoForm");
		List<LevelTwo> lvl2List = lvl2ss.selectByLevelOneAndDD(lvl1f, 1);
		for(LevelTwo lv2 : lvl2List) {
			if(lv2.getName().equalsIgnoreCase(levelTwo.getName().toLowerCase())) {
				mv.addObject("exist", "alredy exist");
				return mv;
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
			mv.addObject("added", "success");
		} else {
			LevelOne lvl1 = new LevelOne();
			lvl1.setLvl1_id(lvl1f);
			LevelTwo lvl2 = new LevelTwo();
			lvl2.setLvl1(lvl1);
			lvl2.setName(levelTwo.getName());
			lvl2.setDd(levelTwo.isDd());
			lvl2ss.saveLevelTwo(lvl2);
			mv.addObject("temp", "success");
		}
		return mv;
	}
	
	@GetMapping("ViewLevelTwo")
	public ModelAndView viewLevelTwo(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "updated", required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(updated == null)) 
			mv.addObject("updated", "Success");
		
		mv.setViewName("ViewLevelTwo");
		mv.addObject("pagedListHolder", masterController.pagination(lvl2ss.selectAll(),request));
		mv.addObject("ValidateLevelOne", new LevelOneValidation());
		return mv;
	}
	
	@PostMapping("EditLevelTwo")
	public ModelAndView editLevelTwo(@Valid @ModelAttribute("ValidateLevelOne") LevelOneValidation lvl, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("ViewLevelTwo");
			mv.addObject("editError", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(lvl2ss.selectAll(),request));
			return mv;
		}
		
		List<LevelTwo> list = lvl2ss.selectAllExceptId(lvl.getLvl2_id());
		
		for(LevelTwo l : list) {
			if(l.getName().replaceAll("//s", "").equalsIgnoreCase(lvl.getName().replaceAll("//s", ""))) {
				mv.setViewName("ViewLevelTwo");
				mv.addObject("editError", "Error");
				mv.addObject("editExist", "Error");
				mv.addObject("pagedListHolder", masterController.pagination(lvl1ss.selectAll(),request));
				return mv;
			}
		}
		
		lvl2ss.updateLevelTwo(lvl.getLvl2_id(),lvl.getName(),lvl.getDd(),lvl.getLvl1().getLvl1_id(),lvl.isInn() ? 1 : 0);
		
		mv.setViewName("ViewLevelTwo");
		mv.addObject("pagedListHolder", masterController.pagination(lvl2ss.selectAll(),request));
		mv.addObject("updated", "Success");
		return mv;
	}
	
	@GetMapping("LevelThreeForm")
	public ModelAndView addLevelThree(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
		return mv;
		}
		
		mv.setViewName("LevelThreeForm");
		mv.addObject("levelThree", new AddLevelThree());
		return mv;
	}
	
	@PostMapping("saveLvl3")
	public ModelAndView saveLevelThree(@Valid @ModelAttribute("levelThree") AddLevelThree levelThree,BindingResult result,HttpSession session) {
		
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("LevelThreeForm");
			return mv;
		}

		mv.setViewName("LevelThreeForm");
		List<Menu> exist = new ArrayList<Menu>();
		try {
			exist = menuService.selectByLevelOnTwoThreeId(levelThree.getLvl1(), levelThree.getLvl2(),
					levelThree.getLvl3());
			if (exist.size() == 1) {
				System.out.println("exist");
				mv.addObject("exist", "already exist");
				return mv;
			} else {
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
				mv.addObject("added", "success");
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		return mv;
	}

	@GetMapping("ViewLevelThree")
	public ModelAndView viewLevelThree(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "updated", required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(updated == null)) 
			mv.addObject("updated", "Success");
		
		mv.setViewName("ViewLevelThree");
		mv.addObject("pagedListHolder", masterController.pagination(lvl3ss.selectAll(),request));
		mv.addObject("ValidateLevelOne", new LevelOneValidation());
		return mv;
	}
	
	@PostMapping("EditLevelThree")
	public ModelAndView editLevelThree(@Valid @ModelAttribute("ValidateLevelOne") LevelOneValidation lvl, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("ViewLeveThree");
			mv.addObject("editError", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(lvl3ss.selectAll(),request));
			return mv;
		}
		
		List<LevelThree> list = lvl3ss.selectAllExceptId(lvl.getLvl3_id());
		
		for(LevelThree l : list) {
			if(l.getName().replaceAll("//s", "").equalsIgnoreCase(lvl.getName().replaceAll("//s", ""))) {
				mv.setViewName("ViewLevelThree");
				mv.addObject("editError", "Error");
				mv.addObject("editExist", "Error");
				mv.addObject("pagedListHolder", masterController.pagination(lvl3ss.selectAll(),request));
				return mv;
			}
		}
		
		lvl3ss.updateLevelThree(lvl.getLvl3_id(),lvl.getName(),lvl.isInn() ? 1 : 0);
		
		mv.setViewName("ViewLevelThree");
		mv.addObject("pagedListHolder", masterController.pagination(lvl3ss.selectAll(),request));
		mv.addObject("updated", "Success");
		return mv;
	}
	
	@GetMapping("DeleteLevelOne")
	public ModelAndView getDeleteLevelOneForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		mv.setViewName("DeleteLevelOne");
		mv.addObject("lvl1", lvl1ss.selectAll());
		mv.addObject("deleteLevelOne", new DeleteLevelOne());
		return mv;
	}

	@PostMapping("deleteLevelOne")
	public ModelAndView deleteLevelOne(@Valid @ModelAttribute("deleteLevelOne") DeleteLevelOne deleteLevelOne,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if(result.hasErrors()) {
			mv.setViewName("DeleteLevelOne");
			return mv;
		}
		
		mv.setViewName("DeleteLevelOne");
		mv.addObject("deleted", "success");
		lvl1ss.deleteById(deleteLevelOne.getLvl1());
		return mv;
	}

	@GetMapping("DeleteLevelTwo")
	public ModelAndView getDeleteLevelTwo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		mv.setViewName("DeleteLevelTwo");
		List<LevelOne> lvl1 = lvl1ss.selectByDd(1);
		mv.addObject("lvl1i", lvl1);
		mv.addObject("deleteLevelTwo", new DeleteLevelTwo());
		return mv;
	}

	@PostMapping("deleteLevelTwo")
	public ModelAndView deleteLevelTwo(@Valid @ModelAttribute("deleteLevelTwo") DeleteLevelTwo deleteLevelTwo,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("DeleteLevelTwo");
			return mv;
		}
		
		mv.setViewName("DeleteLevelTwo");
		lvl2ss.deleteById(deleteLevelTwo.getLvl2());
		mv.addObject("deleted", "success");
		return mv;
	}

	@GetMapping("DeleteLevelThree")
	public ModelAndView getDeleteLevelThree(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
		return mv;
		}
		
		mv.setViewName("DeleteLevelThree");
		mv.addObject("lvl1i", lvl1ss.selectByDd(1));
		mv.addObject("deleteLevelThree", new DeleteLevelThree());
		return mv;
	}

	@PostMapping("deleteLevelThree")
	public ModelAndView deleteLevelThee(@Valid DeleteLevelThree levelThree,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("DeleteLevelThree");
			return mv;
		}
		
		mv.setViewName("DeleteLevelThree");
		mv.addObject("deleted", "success");
		menuService.deleteByLevelId(levelThree.getLvl1(), levelThree.getLvl2(), levelThree.getLvl3());
		return mv;
	}
}
