package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.ExternalValidation;
import com.project.service.ExternalService;
import com.project.service.SyllabusService;

@Controller
public class ResultController {

	@Autowired
	SyllabusService sylService;
	
	@Autowired
	ExternalService extService;
	
	@GetMapping("AddInternal")
	public ModelAndView getAddinternal(HttpSession session,HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="deleted", required=false) String deleted,
			@RequestParam(value="updated", required=false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		
		mv.setViewName("AddInternal");
		return mv;
	}	
	
	@GetMapping("AddExternal")
	public ModelAndView getAddExternal(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="deleted", required=false) String deleted,
			@RequestParam(value="updated", required=false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		
		mv.setViewName("AddExternal");
		return mv;
	}
	
	@GetMapping("Semester1")
	public ModelAndView getSemester1(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester1");
		mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", sylService.selectAll());
		return mv;
	}
	
	@PostMapping("SaveSemester1")
	public ModelAndView saveSemester1(@Valid @ModelAttribute("external") ExternalValidation ex,BindingResult result,
			HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("resiret:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(result.hasErrors()) {
			mv.setViewName("Semester1");
			return mv;
		}
		
		extService.saveExternalMarks(
				ex.getUser_id(),ex.getMa5161(),ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),
				ex.getMc5005(),ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),ex.getMc5101(),
				ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),ex.getMc5211(),
				ex.getMc5212(),ex.getMc5213(),ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),
				ex.getMc5305(),ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),ex.getMc5401(),ex.getMc5402(),
				ex.getMc5403(),ex.getMc5404(),ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),ex.getMc5501(),
				ex.getMc5502(),ex.getMc5503(),ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),ex.getMc5611(),
				ex.isInn() ? 1 : 0);

		mv.setViewName("redirect:/Semester1");
		mv.addObject("added", "Success");
		return mv;
	}
}