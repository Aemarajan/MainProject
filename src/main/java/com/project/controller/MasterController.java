package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.BatchMaster;
import com.project.service.BatchMasterService;

@Controller
public class MasterController {

	@Autowired
	BatchMasterService bmservice;
	
	@GetMapping("GetBatchMaster")
	public String getBatchMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		else {
			return "BatchMaster";
		}
	}
	
	@PostMapping("SaveBatchMaster")
	public ModelAndView saveBatchMaster(BatchMaster bm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		else {
			int f_year = bm.getFrom_year();
			int t_year = bm.getTo_year();
			int n_year = t_year - f_year;
			
			bm.setNo_of_years(n_year);		
			
			bmservice.saveBatchMaster(bm);
			
			ModelAndView mv = new ModelAndView("BatchMaster");
			mv.addObject("added", "Success Message");
			return mv;
		}
	}
}