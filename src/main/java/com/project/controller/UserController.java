package com.project.controller;

import java.util.List;

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

import com.project.config.PasswordGenerator;
import com.project.customvalidator.SignUp;
import com.project.model.User;
import com.project.service.GraduateService;
import com.project.service.MailService;
import com.project.service.PrivilegeService;
import com.project.service.ProfileService;
import com.project.service.SchoolingService;
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

	@Autowired
	ProfileService profileService;

	@Autowired
	MasterController masterController;
	
	@Autowired
	SchoolingService schoolService;
	
	@Autowired
	GraduateService graduationService;
	
	@GetMapping("SignUp")
	public ModelAndView getSignup(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "updated", required = false) String updated,
			@RequestParam(value = "deleted", required = false) String deleted) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Session Expired");
			return mv;
		}
		if (!(added == null))
			mv.addObject("added", "success");
		if (!(updated == null))
			mv.addObject("updated", "success");
		if (!(deleted == null))
			mv.addObject("deleted", "success");
		
		mv.setViewName("SignUp");
		//mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
		mv.addObject("pagedListHolder1", masterController.pagination(userService.selectAllAdministrators(), request));
		mv.addObject("pagedListHolder2", masterController.pagination(userService.selectAllStaffs(), request));
		mv.addObject("pagedListHolder3", masterController.pagination(userService.selectAllStudents(), request));
		mv.addObject("signup", new SignUp());
		return mv;
	}

	@PostMapping("CreateUser")
	public ModelAndView createUser(@Valid @ModelAttribute("signup") SignUp signup, 
			BindingResult result,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Session Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("SignUp");
			mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
			mv.addObject("addError", "Error");
			return mv;
		}
		User user = new User();

		user.setRole(signup.getRole());
		user.setName(signup.getName());
		user.setEmail(signup.getEmail());
		user.setUsername(signup.getUsername());
		user.setPassword(new PasswordGenerator().generateRandomPassword(15));
		user.setPrivilege_provide(0);

		userLoc = user;

		User userExist1 = userService.findByEmail(user.getEmail());
		User userExist2 = userService.findByUsername(user.getUsername());

		if (!(userExist1 == null)) {
			mv.setViewName("SignUp");
			mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
			mv.addObject("addEmailExist", "Email id already registerd. Please try Another Email id...");
			mv.addObject("addError", "Error");
		} else if (!(userExist2 == null)) {
			mv.setViewName("SignUp");
			mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
			mv.addObject("addUsernameExist", "Username already registerd. Please try Another Name...");
			mv.addObject("addError", "Error");
		} else {
			//mailService.sendDetails(userLoc);
			userService.createUser(signup.getRole().toLowerCase(),signup.getName().toLowerCase(),signup.getEmail().toLowerCase(),signup.getUsername().toLowerCase(),user.getPassword(),user.getPrivilege_provide(),signup.isInn());
			//profileService.createUserProfile(userLoc.getUser_id());
			//schoolService.createSchoolProfile(userLoc.getUser_id(),"SSLC");
			//schoolService.createSchoolProfile(userLoc.getUser_id(),"HSC");
			
			mv.setViewName("redirect:/SignUp");
			mv.addObject("added", "success");
		}
		return mv;
	}
	
	@PostMapping("EditUser")
	public ModelAndView editUser(@Valid @ModelAttribute("signup") SignUp signup, 
			BindingResult result,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Session Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("SignUp");
			mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
			mv.addObject("editError", "Error");
			return mv;
		}
		
		List<User> exist = userService.selectAllExceptId(signup.getUser_id());

		for(User u : exist) {
			if (u.getEmail().equalsIgnoreCase(signup.getEmail())) {
				mv.setViewName("SignUp");
				mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
				mv.addObject("editError", "Error");
				mv.addObject("editEmailExist", "Email id already registerd. Please try Another Email id...");
			} else if (u.getUsername().equalsIgnoreCase(signup.getUsername())) {
				mv.setViewName("SignUp");
				mv.addObject("pagedListHolder", masterController.pagination(userService.selectAllUser(), request));
				mv.addObject("editError", "Error");
				mv.addObject("editUsernameExist", "Username already registerd. Please try Another Name...");
			}
		}

		userService.updateUser(signup.getUser_id(),signup.getRole().toLowerCase(),signup.getName().toLowerCase(),signup.getEmail().toLowerCase(),signup.getUsername(),signup.getPassword(),signup.getPrivilege_provide(),signup.isInn());
		
		mv.setViewName("redirect:/SignUp");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteUser")
	public ModelAndView deleteuser(@RequestParam("user_id") int id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		userService.updateInnZero(id, 0);
		
		mv.setViewName("redirect:/SignUp");
		mv.addObject("deleted", "success");
		return mv;
	}
}