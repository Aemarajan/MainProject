package com.project.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.service.MailService;
import com.project.service.UserService;
import com.project.validator.ChangePassword;
import com.project.validator.ForgotPassword;
import com.project.validator.OTP;
import com.project.validator.SignIn;

@Controller
public class MainController {

	@Autowired 
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	User userExist;
	int otp;
	
	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/SignIn");
		return mv;
		// return "redirect:/show";
	}

	@RequestMapping("SignIn")
	public ModelAndView getSignInForm(@RequestParam(value = "session", required = false) String session) {
		ModelAndView mv = new ModelAndView();
		
		if (!(session == null))
			mv.addObject("session", "expired");
	
		mv.setViewName("SignIn");
		mv.addObject("signin", new SignIn());
		mv.addObject("forgotPassword", new ForgotPassword());
		mv.addObject("otp", new OTP());
		return mv;
	}
	
	@PostMapping("Login")
	public ModelAndView checkUser(@Valid @ModelAttribute("signin") SignIn signin, BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("SignIn");
			return mv;
		}
		try {
			User userloc = userService.findByUsername(signin.getUsername());
			if (userloc.getPassword().equals(signin.getPassword())) {
				session.setAttribute("name", userloc.getName());
				session.setAttribute("id", userloc.getUser_id());
				mv.setViewName("redirect:/home");
			} else {
				mv.setViewName("SignIn");
				mv.addObject("msg", "fail");
			}
		} catch (NullPointerException e) {
			mv.setViewName("SignIn");
			mv.addObject("msg", "fail");
		}
		return mv;
	}

	@RequestMapping("logout")
	public ModelAndView logout(@RequestParam(value = "session", required = false) String s, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (!(s == null))
			mv.addObject("session", "Expired");
		session.invalidate();
		mv.setViewName("redirect:/SignIn");
		return mv;
	}
	
	@PostMapping("SendOTP")
	public ModelAndView getOtpVerification(@Valid @ModelAttribute("forgotPassword") ForgotPassword forgotPassword,BindingResult result, @ModelAttribute("signin")SignIn signin,@ModelAttribute("otp")OTP otpObj) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("SignIn");
			mv.addObject("forgotModal", "Error");
			return mv;
		}
		
		Random rand = new Random();
		otp = 100000 + rand.nextInt(900000);
		
		try {
			User userExist = userService.findByEmail(forgotPassword.getEmail());
			
			User user = new User();
			user.setEmail(forgotPassword.getEmail());
			user.setName(userExist.getName());
	
			mailService.sendEmail(user, otp);
			mv.setViewName("SignIn");
			mv.addObject("otpModal", "Message");
			mv.addObject("email", forgotPassword.getEmail());
			return mv;
		}catch(NullPointerException e) {
			mv.setViewName("SignIn");
			mv.addObject("forgotModal", "Error");
			mv.addObject("emailError", "Oops! This Email id is not Registerd...");
			return mv;
		}
	}
	
	@PostMapping("VerifyOTP")
	public ModelAndView verifyOTP(@Valid @ModelAttribute("otp") OTP useotp,BindingResult result,@ModelAttribute("signin")SignIn signin,@ModelAttribute("forgotPassword")ForgotPassword forgot) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("SignIn");
			mv.addObject("otpModal", "Message");
			return mv;
		}
		
		if(otp == useotp.getOtp()) {
			mv.setViewName("SignIn");
			//mv.addObject("resetPassword", new ResetPassword());
			//mv.addObject("msg", "success");
			//mailService.sendDetails(userLoc);
			//userService.createUser(userLoc);
			return mv;
		}else {
			mv.setViewName("SignIn");
			mv.addObject("otpModal", "Error");
			mv.addObject("otpError","Invalid OTP, Please try later");
		return mv;
		}
	}
	
//	@RequestMapping("VerificationForm")
//	public ModelAndView getOTPVerification(@Valid @ModelAttribute("signup") SignUp signup, BindingResult result,HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		
//		if(session.getAttribute("id") == null) {
//			mv.setViewName("redirect:/logout");
//			mv.addObject("session", "Expired");
//			return mv;
//		}
//		if (result.hasErrors()) {
//			mv.setViewName("SignUp");
//			return mv;
//		}
//		
//		User user = new User();
//		user.setEmail(signup.getEmail());
//		user.setPassword(signup.getPassword());
//		user.setUsername(signup.getUsername());
//		user.setPrivilegeProvide(0);
//
//		Random rand = new Random();
//
//		otp = 100000 + rand.nextInt(900000);
//		userLoc = user;
//
//		User userExist = userService.findByEmail(user.getEmail());
//
//		if (userExist == null) {
//			mailService.sendEmail(user, otp);
//			mv.setViewName("OTP");
//			mv.addObject("otp", new OTP());
//			mv.addObject("email", signup.getEmail());
//		} else {
//			mv.setViewName("SignUp");
//			mv.addObject("exist", "Email id already registerd");
//		}
//		return mv;
//	}
//
//	@RequestMapping("Verify") 
//	public ModelAndView verifyUser(@Valid @ModelAttribute("otp") OTP usotp,BindingResult result,HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		if(session.getAttribute("id") == null) {
//			mv.setViewName("redirect:/logout");
//			mv.addObject("session", "Expired");
//			return mv;
//		}
//		if(result.hasErrors()) {
//			mv.setViewName("OTP");
//			return mv;
//		} 
//		 
//		if(otp == usotp.getOtp()) {
//			mv.setViewName("ChangePassword"); 
//			mv.addObject("msg", "success");
//			mailService.sendDetails(userLoc); 
//			userService.createUser(userLoc); 
//		}
//		else {
//			mv.setViewName("OTP"); 
//			mv.addObject("msg","Invalid OTP, Please try later");
//			return mv;
//		}
//		return mv;
//	}
	
	@GetMapping("home")
	public ModelAndView getHome(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.setViewName("Home");
		return mv;
	}
	
	@GetMapping("Profile")
	public ModelAndView getProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.setViewName("Profile");
		return mv;
	}

	@GetMapping("ChangePassword")
	public ModelAndView getChangePassword(HttpSession session,@RequestParam(value = "updated", required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (!(updated == null))
			mv.addObject("updated", "Success");

		mv.setViewName("ChangePassword");
		mv.addObject("changePassword", new ChangePassword());
		return mv;
	}

	@PostMapping("UpdatePassword")
	public ModelAndView updatePassword(@Valid @ModelAttribute("changePassword") ChangePassword changePassword,BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("sessioin", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("ChangePassword");
			return mv;
		}
	
		User exist = userService.findByPassword(changePassword.getOld_pwd());
		
		if(!(exist.getPassword().equalsIgnoreCase(changePassword.getOld_pwd()))) {	
			mv.setViewName("ChangePassword");
			mv.addObject("passwordError", "Error");
			return mv;
		}else if(!(changePassword.getNew_pwd().equalsIgnoreCase(changePassword.getConfirm_pwd()))){
			mv.setViewName("ChangePassword");
			mv.addObject("passwordMismatch", "Error");
			return mv;
		}
		
		userService.updatePassword(changePassword.getNew_pwd(),exist.getUser_id());
		
		mv.setViewName("redirect:/ChangePassword");
		mv.addObject("updated", "Success");
		return mv;
	}

	@GetMapping("Gallery")
	public ModelAndView getGallery(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.setViewName("Gallery");
		return mv;
	}
	
	@GetMapping("About")
	public ModelAndView getAbout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.setViewName("About");
		return mv;
	}
	
	@GetMapping("Contact")
	public ModelAndView getContact(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		mv.setViewName("Contact");
		return mv;
	}
	
	/*
	 * @RequestMapping("show") public ModelAndView viewShow(HttpSession session) {
	 * ModelAndView mv = new ModelAndView();
	 * if (session.getAttribute("id") == null) { mv.setViewName("redirect:/logout");
	 * mv.addObject("session", "Expired"); return mv; } mv.setViewName("show");
	 * return mv; }
	 */
}