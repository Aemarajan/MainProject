package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.AddCSD;
import com.project.model.CSDMapping;
import com.project.service.CSDService;
import com.project.service.CountryService;
import com.project.service.DistrictService;
import com.project.service.StateService;

@RestController
public class TransactionController {

	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	CSDService csdService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagedListHolder pagination(List<?> list, HttpServletRequest request) {
		PagedListHolder pageListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pageListHolder.setPage(page);
		pageListHolder.setPageSize(5);
		return pageListHolder;
	}
	
	@GetMapping("CSDMapping")
	public ModelAndView getCSDMapping(HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.addObject("pagedListHolder", pagination(csdService.selectAll(), request));
		mv.setViewName("CSDMapping");
		return mv;
	}
	
	@PostMapping("SaveCSDMapping")
	public ModelAndView saveCSDMapping(AddCSD csd) {
		ModelAndView mv = new ModelAndView();
		csdService.save(new CSDMapping(csd.getId(),countryService.selectById((Integer)csd.getCountry()),stateService.selectById(csd.getState()),districtService.selectById(csd.getDistrict()),csd.isInn()?1:0));
		mv.setViewName("redirect:/CSDMapping");
		return mv;
	}
	
	@GetMapping("changeStatusInCSD")
	public ModelAndView changeStatus(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView("redirect:/CSDMapping");
		CSDMapping c = csdService.selectById(id);
		if(c.getInn() == 1) {
			csdService.updateInn(id,0);
		}
		if(c.getInn() == 0)
		{
			csdService.updateInn(id,1);
		}
		return mv;
	}
	
}
