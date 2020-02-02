package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Batch;
import com.project.model.Bloodgroup;
import com.project.model.Community;
import com.project.model.Country;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.Diploma;
import com.project.service.BatchService;
import com.project.service.BloodgroupService;
import com.project.service.CommunityService;
import com.project.service.CountryService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;
import com.project.service.DiplomaService;
import com.project.validator.AddBatchMaster;

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
	
	@Autowired
	DiplomaService dmservice;
	
	@GetMapping("GetBatchMaster")
	public String getBatchMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("addBatch", new AddBatchMaster());
		return "BatchMaster";
	}
	
	@PostMapping("SaveBatchMaster")
	public ModelAndView saveBatchMaster(@Valid @ModelAttribute("addBatch") AddBatchMaster batch,BindingResult result ,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		if(result.hasErrors()) {
			return new ModelAndView("BatchMaster");
		}
		ModelAndView m = new ModelAndView();
		List<Batch> exist = bmservice.selectBatchByFromTo(Integer.parseInt(batch.getFrom_year()),Integer.parseInt(batch.getTo_year()));
		if(exist.size()!=0) {
			m.setViewName("BatchMaster");
			m.addObject("exist", "already exist");
			return m;
		}
		int f_year = Integer.parseInt(batch.getFrom_year());
		int t_year = Integer.parseInt(batch.getTo_year());
		int n_year = t_year - f_year;
		if(n_year<=4 && n_year>=2) {
			Batch bm = new Batch();
			bm.setFrom_year(f_year);
			bm.setTo_year(t_year);
			bm.setNo_of_years(n_year);		
			bm.setInn(batch.isInn());
			bmservice.saveBatchMaster(bm);

			ModelAndView mv = new ModelAndView("Batch");
			mv.addObject("added", "Success Message");
			return mv;
		}
		m.setViewName("Batch");
		m.addObject("invalidYear", "Invalid year");
		return m;
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
	
	@GetMapping("GetDiplomaMaster")
	public String getDiplomaMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "DiplomaMaster";
	}
	
	@PostMapping("SaveDiplomaMaster")
	public ModelAndView saveDiplomaMaster(Diploma dm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		dmservice.saveDiplomaMaster(dm);
			
		ModelAndView mv = new ModelAndView("DiplomaMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
}