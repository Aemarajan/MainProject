package com.project.controller;

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

import com.project.config.PasswordGenerator;
import com.project.customvalidator.SignUp;
import com.project.model.User;
import com.project.service.MailService;
import com.project.service.PrivilegeService;
import com.project.service.UserService;

@Controller
public class UserController {

	int otp;
	User userLoc;

	@Autowired
	UserService userService;

	@Autowired
	MailService mailService;

	@Autowired
	PrivilegeService privilegeService;

	@GetMapping("SignUp")
	public ModelAndView getSignup(HttpSession session, @RequestParam(value = "added", required = false) String added) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Session Expired");
			return mv;
		}
		if (!(added == null))
			mv.addObject("added", "success");
		mv.setViewName("SignUp");
		mv.addObject("signup", new SignUp());
		return mv;
	}

	@PostMapping("VerificationForm")
	public ModelAndView getSignup(@Valid @ModelAttribute("signup") SignUp signup, BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Session Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("SignUp");
			mv.addObject("addError", "Error");
			return mv;
		}
		User user = new User();

		user.setRole(signup.getRole());
		user.setName(signup.getName());
		user.setEmail(signup.getEmail());
		user.setUsername(signup.getUsername());
		user.setPassword(new PasswordGenerator().generateRandomPassword(15));
		user.setPrivilegeProvide(0);

		userLoc = user;

		User userExist1 = userService.findByEmail(user.getEmail());
		User userExist2 = userService.findByUsername(user.getUsername());

		if (!(userExist1 == null)) {
			mv.setViewName("SignUp");
			mv.addObject("emailExist", "Email id already registerd. Please try Another Email id...");
		} else if (!(userExist2 == null)) {
			mv.setViewName("SignUp");
			mv.addObject("usernameExist", "Username already registerd. Please try Another Name...");
		} else {
			mv.setViewName("redirect:/SignUp");
			mv.addObject("added", "success");
			mailService.sendDetails(userLoc);
			userService.createUser(userLoc);
		}
		return mv;
	}
}