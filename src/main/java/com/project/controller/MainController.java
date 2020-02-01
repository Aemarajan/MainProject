package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.validator.SignIn;


@Controller
public class MainController {

	Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String getHome() {
		log.info("Index Accessed.....");
		return "redirect:/SignIn";
		//return "redirect:/show";
	}
	
	@RequestMapping("SignIn")
	public String getSignInForm(Model model) {
		model.addAttribute("signin", new SignIn());
		log.info("Sign In Accessed....");
		return "SignIn";
	}
	
}
