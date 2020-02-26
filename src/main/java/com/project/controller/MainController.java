package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.validator.SignIn;


@Controller
public class MainController {

	@RequestMapping("/")
	public String getHome() {
		return "redirect:/SignIn";
		//return "redirect:/show";
	}
	
	@RequestMapping("SignIn")
	public ModelAndView getSignInForm(@RequestParam(value="session",required=false)String session) {
		ModelAndView mv = new ModelAndView();
		if(!(session == null))
			mv.addObject("session", "expired");
		mv.addObject("signin", new SignIn());
		mv.setViewName("SignIn");
		return mv;
	}
	
}
