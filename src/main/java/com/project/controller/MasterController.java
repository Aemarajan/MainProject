package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Batch;
import com.project.model.Bloodgroup;
import com.project.model.Community;
import com.project.model.Country;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.service.BatchService;
import com.project.service.BloodgroupService;
import com.project.service.CommunityService;
import com.project.service.CountryService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;

@Controller
public class MasterController {

	@Autowired
	BatchService bmservice;
	
	@Autowired
	BloodgroupService bgmservice;
	
	@Autowired
	CommunityService cmservice;
	
	@Autowired
	CountryService cnservice;
	
	@Autowired
	DegreeService dgservice;
	
	@Autowired
	DepartmentService dpservice;
	
	@GetMapping("GetBatchMaster")
	public String getBatchMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "BatchMaster";
	}
	
	@PostMapping("SaveBatchMaster")
	public ModelAndView saveBatchMaster(Batch bm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		
		int f_year = bm.getFrom_year();
		int t_year = bm.getTo_year();
		int n_year = t_year - f_year;
			
		bm.setNo_of_years(n_year);		
			
		bmservice.saveBatchMaster(bm);
			
		ModelAndView mv = new ModelAndView("BatchMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetBloodGroupMaster")
	public String getBloodgroupMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "BloodgroupMaster";
	}
	
	@PostMapping("SaveBloodGroupMaster")
	public ModelAndView saveBloodgroupMaster(Bloodgroup bgm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		bgmservice.saveBloodgroupMaster(bgm);
			
		ModelAndView mv = new ModelAndView("BloodgroupMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetCommunityMaster")
	public String getCommunityMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "CommunityMaster";
	}
	
	@PostMapping("SaveCommunityMaster")
	public ModelAndView saveCommunityMaster(Community cm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		cmservice.saveCommunityMaster(cm);
			
		ModelAndView mv = new ModelAndView("CommunityMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	
	@GetMapping("GetCountryMaster")
	public String getCountryMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "CountryMaster";
	}
	
	@PostMapping("SaveCountryMaster")
	public ModelAndView saveCountryMaster(Country cn,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		cnservice.saveCountryMaster(cn);
			
		ModelAndView mv = new ModelAndView("CountryMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetDegreeMaster")
	public String getDegreeMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "DegreeMaster";
	}
	
	@PostMapping("SaveDegreeMaster")
	public ModelAndView saveDegreeMaster(Degree dgm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		dgservice.saveDegreeMaster(dgm);
			
		ModelAndView mv = new ModelAndView("DegreeMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetDepartmentMaster")
	public String getDepartmentMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "DepartmentMaster";
	}
	
	@PostMapping("SaveDepartmentMaster")
	public ModelAndView saveDepartmentMaster(Department dpm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		dpservice.saveDepartmentMaster(dpm);
			
		ModelAndView mv = new ModelAndView("DepartmentMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	
}