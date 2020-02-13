package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.validator.SignIn;


@Controller
public class MainController {

	@RequestMapping("/")
	public String getHome() {
		return "redirect:/SignIn";
		//return "redirect:/show";
	}
	
	@RequestMapping("SignIn")
	public String getSignInForm(Model model) {
		model.addAttribute("signin", new SignIn());
		return "SignIn";
	}
	
}
