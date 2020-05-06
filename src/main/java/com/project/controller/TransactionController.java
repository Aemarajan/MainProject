package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.CSDMappingValidation;
import com.project.customvalidator.SSMappingValidation;
import com.project.model.CSDMapping;
import com.project.model.SSMapping;
import com.project.service.CSDService;
import com.project.service.CountryService;
import com.project.service.DistrictService;
import com.project.service.SSMappingService;
import com.project.service.StateService;
import com.project.service.UserService;

@RestController
public class TransactionController {

	@Autowired
	UserService userService;
	
	@Autowired
	MasterController masterController;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	CSDService csdService;
	
	@Autowired
	SSMappingService ssService;
	
	@GetMapping("CSDMapping")
	public ModelAndView getCSDMapping(HttpSession session,HttpServletRequest request,
			@RequestParam(value="added",required = false) String added,
			@RequestParam(value="deleted",required = false) String deleted,
			@RequestParam(value="updated",required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		if(!(deleted == null))
			mv.addObject("deleted", "Success");
		if(!(updated == null))
			mv.addObject("updated", "Success");
		
		mv.setViewName("CSDMapping");
		mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
		mv.addObject("csdMapping", new CSDMappingValidation());
		return mv;
	}
	
	@PostMapping("SaveCSDMapping")
	public ModelAndView saveCSDMapping(@Valid @ModelAttribute("csdMapping")CSDMappingValidation csd,
			BindingResult result,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("CSDMapping");
			mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
			mv.addObject("addError", "Error");
			return mv;
		}
		
		List<CSDMapping> list = csdService.selectAll();
		
		for(CSDMapping c : list) {
			if((c.getDistrict().getId()) == csd.getDistrict()) {
				mv.setViewName("CSDMapping");
				mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
				mv.addObject("addError", "Error");
				mv.addObject("addExist", "Error");
				return mv;
			}
		}
				
		csdService.save(new CSDMapping(
				csd.getId(),
				countryService.selectById((Integer)csd.getCountry()),
				stateService.selectById(csd.getState()),
				districtService.selectById(csd.getDistrict()),
				csd.isInn()?1:0));
		
		mv.setViewName("redirect:/CSDMapping");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("changeStatusInCSD")
	public ModelAndView changeCSDStatus(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView();
		
		CSDMapping c = csdService.selectById(id);
		
		if(c.getInn() == 1) {
			csdService.updateInn(id,0);
			mv.setViewName("redirect:/CSDMapping");
			mv.addObject("deleted", "Success");
		}
		if(c.getInn() == 0)
		{
			csdService.updateInn(id,1);
			mv.setViewName("redirect:/CSDMapping");
			mv.addObject("updated", "Success");
		}
		return mv;
	}
	
	@GetMapping("SSMapping")
	public ModelAndView getSSMapping(HttpSession session,HttpServletRequest request,
			@RequestParam(value="added",required = false) String added,
			@RequestParam(value="deleted",required = false) String deleted,
			@RequestParam(value="updated",required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		if(!(deleted == null))
			mv.addObject("deleted", "Success");
		if(!(updated == null))
			mv.addObject("updated", "Success");
		
		mv.setViewName("SSMapping");
		mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
		mv.addObject("ssMapping", new SSMappingValidation());
		return mv;
	}
	
	@PostMapping("SaveSSMapping")
	public ModelAndView saveSSMapping(@Valid @ModelAttribute("ssMapping")SSMappingValidation ss,
			BindingResult result,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("SSMapping");
			mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
			mv.addObject("addError", "Error");
			return mv;
		}
		
		List<SSMapping> list = ssService.selectAll();
		
		for(SSMapping s : list) {
			if((s.getStudent().getUser_id()) == ss.getStudent()) {
				mv.setViewName("SSMapping");
				mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
				mv.addObject("addError", "Error");
				mv.addObject("addExist", "Error");
				return mv;
			}
		}
		
		ssService.save(
				new SSMapping(
						ss.getId(),
						userService.selectById((Integer)ss.getStaff()),
						userService.selectById(ss.getStudent()),
						ss.isInn() ? 1 : 0));
		
		mv.setViewName("redirect:/SSMapping");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("changeStatusInSSMapping")
	public ModelAndView changeSSMappingStatus(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView();
		
		SSMapping s = ssService.selectById(id);
		
		if(s.getInn() == 1) {
			ssService.updateInn(id,0);
			mv.setViewName("redirect:/SSMapping");
			mv.addObject("deleted", "Success");
		}
		if(s.getInn() == 0)
		{
			ssService.updateInn(id,1);
			mv.setViewName("redirect:/SSMapping");
			mv.addObject("updated", "Success");
		}
		return mv;
	}
}