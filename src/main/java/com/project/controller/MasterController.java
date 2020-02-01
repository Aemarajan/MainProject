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

import com.project.model.BatchMaster;
import com.project.service.BatchMasterService;
import com.project.validator.AddBatchMaster;

@Controller
public class MasterController {

	@Autowired
	BatchMasterService bmservice;
	
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
		List<BatchMaster> exist = bmservice.selectBatchByFromTo(Integer.parseInt(batch.getFrom_year()),Integer.parseInt(batch.getTo_year()));
		if(exist.size()!=0) {
			m.setViewName("BatchMaster");
			m.addObject("exist", "already exist");
			return m;
		}
		int f_year = Integer.parseInt(batch.getFrom_year());
		int t_year = Integer.parseInt(batch.getTo_year());
		int n_year = t_year - f_year;
		if(n_year<=4 && n_year>=2) {
			BatchMaster bm = new BatchMaster();
			bm.setFrom_year(f_year);
			bm.setTo_year(t_year);
			bm.setNo_of_years(n_year);		
			bm.setInn(batch.isInn());
			bmservice.saveBatchMaster(bm);
			
			ModelAndView mv = new ModelAndView("BatchMaster");
			mv.addObject("added", "Success Message");
			return mv;
		}
		m.setViewName("BatchMaster");
		m.addObject("invalidYear", "Invalid year");
		return m;
	}
}