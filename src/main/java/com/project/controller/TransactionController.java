package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.AddCSD;
import com.project.customvalidator.AddDDS;
import com.project.model.CSDMapping;
import com.project.model.DDSMapping;
import com.project.service.BatchService;
import com.project.service.CSDService;
import com.project.service.CountryService;
import com.project.service.DDSService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;
import com.project.service.DistrictService;
import com.project.service.RegulationService;
import com.project.service.SectionService;
import com.project.service.SemesterService;
import com.project.service.StateService;
import com.project.service.YearService;

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
	
	@Autowired
	DDSService ddsService;
	
	@Autowired
	DegreeService degreeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	BatchService batchService;
	
	@Autowired
	SectionService sectionService;
	
	@Autowired
	RegulationService regulationService;
	
	@Autowired
	YearService yearService;
	
	@Autowired
	SemesterService semesterService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagedListHolder pagination(List<?> list, HttpServletRequest request) {
		PagedListHolder pageListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pageListHolder.setPage(page);
		pageListHolder.setPageSize(5);
		return pageListHolder;
	}
	
	@GetMapping("CSDMapping")
	public ModelAndView getCSDMapping(@RequestParam(value="added",required=false)String added,
			@RequestParam(value="ati",required=false) String ati,
			@RequestParam(value="ita",required=false) String ita,
			HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(ati == null))
			mv.addObject("ati", "success");
		if(!(ita == null))
			mv.addObject("ita", "success");
		mv.addObject("pagedListHolder", pagination(csdService.selectAll(), request));
		mv.setViewName("CSDMapping");
		mv.addObject("csd", new AddCSD());
		return mv;
	}
	
	@PostMapping("SaveCSDMapping")
	public ModelAndView saveCSDMapping(@Valid @ModelAttribute("csd") AddCSD csd, BindingResult result,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("CSDMapping");
			mv.addObject("pagedListHolder", pagination(csdService.selectAll(), request));
			mv.addObject("addError", "error");
			return mv;
		}
		CSDMapping exist = csdService.selectByAllColumnId(csd.getCountry(),csd.getState(),csd.getDistrict());
		if(!(exist == null)) {
			mv.setViewName("CSDMapping");
			mv.addObject("pagedListHolder", pagination(csdService.selectAll(), request));
			mv.addObject("addError", "error");
			mv.addObject("addExistCSD", "exist");
			return mv;
		}
		csdService.save(new CSDMapping(csd.getId(),countryService.selectById((Integer)csd.getCountry()),stateService.selectById(csd.getState()),districtService.selectById(csd.getDistrict()),csd.isInn()?1:0));
		mv.setViewName("redirect:/CSDMapping");
		mv.addObject("added", "success");
		return mv;
	}
	
	@GetMapping("changeStatusInCSD")
	public ModelAndView changeStatus(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView("redirect:/CSDMapping");
		CSDMapping c = csdService.selectById(id);
		if(c.getInn() == 1) {
			csdService.updateInn(id,0);
			mv.addObject("ati", "success");
		}
		if(c.getInn() == 0)
		{
			csdService.updateInn(id,1);
			mv.addObject("ita", "success");
		}
		return mv;
	}
	
	@GetMapping("GetDDSMapping")
	public ModelAndView getDDSMapping(@RequestParam(value="added",required=false)String added,
			@RequestParam(value="ati",required=false)String ati, 
			@RequestParam(value="ita",required=false)String ita,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(ati == null))
			mv.addObject("ati", "success");
		if(!(ita == null))
			mv.addObject("ita", "success");
		mv.addObject("pagedListHolder", pagination(ddsService.selectAll(), request));
		mv.setViewName("DDSMapping");
		mv.addObject("dds", new AddDDS());
		return mv;
	}
	
	@PostMapping("SaveDDSMapping")
	public ModelAndView saveDDSMapping(@Valid @ModelAttribute("dds")AddDDS dds, BindingResult result, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(result.hasErrors()) {
			mv.addObject("pagedListHolder", pagination(ddsService.selectAll(), request));
			mv.setViewName("DDSMapping");
			mv.addObject("addError", "error");
			return mv;
		}
		DDSMapping exist = ddsService.selectByAllId(dds.getDegree(),dds.getDepartment(),dds.getSection());
		if(!(exist == null)) {
			mv.setViewName("DDSMapping");
			mv.addObject("pagedListHolder", pagination(ddsService.selectAll(), request));
			mv.addObject("addError", "error");
			mv.addObject("addExist", "exist");
			return mv;
		}
		ddsService.save(batchService.selectById(dds.getBatch()),regulationService.selectById(dds.getRegulation()),degreeService.selectById(dds.getDegree()),departmentService.selectById(dds.getDepartment()),yearService.selectById(dds.getYear()),semesterService.selectById(dds.getSemester()),sectionService.selectById(dds.getSection()),dds.isInn()?1:0);
		mv.setViewName("redirect:/GetDDSMapping");
		mv.addObject("added", "success");
		return mv;
	}
	
	@GetMapping("changeStatusInDDS")
	public ModelAndView changeStatusInDDS(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView("redirect:/GetDDSMapping");
		DDSMapping c = ddsService.selectById(id);
		if(c.getInn() == 1) {
			ddsService.updateInn(id,0);
			mv.addObject("ati", "success");
		}
		if(c.getInn() == 0)
		{
			ddsService.updateInn(id,1);
			mv.addObject("ita", "success");
		}
		return mv;
	}
	
}
