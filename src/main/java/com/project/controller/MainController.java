package com.project.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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

import com.project.customvalidator.ChangePassword;
import com.project.customvalidator.ExperienceValidation;
import com.project.customvalidator.ForgotPassword;
import com.project.customvalidator.OTP;
import com.project.customvalidator.SignIn;
import com.project.model.Experience;
import com.project.model.LevelOne;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.Privilege;
import com.project.model.User;
import com.project.service.ExperienceService;
import com.project.service.LevelOneService;
import com.project.service.LevelThreeService;
import com.project.service.LevelTwoService;
import com.project.service.MailService;
import com.project.service.MenuService;
import com.project.service.PrivilegeService;
import com.project.service.UserService;

@Controller
public class MainController {

	@Autowired
	LevelOneService lvl1ss;

	@Autowired
	LevelTwoService lvl2ss;

	@Autowired
	LevelThreeService lvl3ss;

	@Autowired
	MenuService menuService;

	@Autowired
	PrivilegeService privilegeService;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ExperienceService expService;
	
	@Autowired
	MasterController masterController;
	
	User userExist;
	int otp;
	
	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/SignIn");
		return mv;
	}

	@RequestMapping("SignIn")
	public ModelAndView getSignInForm(@RequestParam(value = "session", required = false) String session,
			@RequestParam(value = "updated", required = false) String updated) {
		ModelAndView mv = new ModelAndView();
		
		if (!(session == null))
			mv.addObject("session", "expired");
		if(!(updated == null))
			mv.addObject("updated", "Success");
	
		mv.setViewName("SignIn");
		mv.addObject("signin", new SignIn());
		mv.addObject("forgotPassword", new ForgotPassword());
		mv.addObject("otp", new OTP());
		mv.addObject("changePassword", new ChangePassword());
		return mv;
	}
	
	@PostMapping("Login")
	public ModelAndView checkUser(@Valid @ModelAttribute("signin") SignIn signin,
			BindingResult result,HttpSession session,
			@ModelAttribute("forgotPassword") ForgotPassword forgotPasswrod,
			@ModelAttribute("otp")OTP otpObj,
			@ModelAttribute("changePassword") ChangePassword changePassword) {
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
				session.setAttribute("role", userloc.getRole());
				
				List<Menu> menuList = new ArrayList<Menu>();
				List<LevelOne> lvl1p = new ArrayList<LevelOne>();
				List<LevelTwo> lvl2p = new ArrayList<LevelTwo>();
				List<Privilege> listPri = privilegeService.selectByUserIdAndInn((int)(userloc.getUser_id()), 1);
				Set<LevelOne> lvl1set = new HashSet<LevelOne>();
				Set<LevelTwo> lvl2set = new HashSet<LevelTwo>();
				for(Privilege p : listPri) {
					menuList.add(p.getMenu_id());
					lvl1set.add(p.getMenu_id().getLvl1());
					if(p.getMenu_id().getLvl2() == null)
						continue;
					else
						lvl2set.add(p.getMenu_id().getLvl2());
				}
				List<LevelOne> lvl1t = lvl1ss.selectAll();
				for(LevelOne l1 : lvl1t) {
					for(LevelOne lv1 :lvl1set) {
						if(l1.getLvl1_id() == lv1.getLvl1_id())
							lvl1p.add(l1);
					}
				}
				List<LevelTwo> lvl2t = lvl2ss.selectAll();
				for(LevelTwo l2 : lvl2t) {
					for(LevelTwo lv2 : lvl2set) {
						if(l2.getLvl2_id() == lv2.getLvl2_id())
							lvl2p.add(l2);
					}
				}
				
				session.setAttribute("menu", menuList);
				session.setAttribute("lvl1", lvl1p);
				session.setAttribute("lvl2", lvl2p);
				session.setAttribute("lvl3", lvl3ss.selectAll());
				
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
	public ModelAndView getOtpVerification(@Valid @ModelAttribute("forgotPassword") ForgotPassword forgotPassword,
			BindingResult result, 
			@ModelAttribute("signin")SignIn signin,
			@ModelAttribute("otp")OTP otpObj,
			@ModelAttribute("changePassword") ChangePassword changePassword) {
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
	
			//mailService.sendEmail(user, otp);
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
	public ModelAndView verifyOTP(@Valid @ModelAttribute("otp") OTP useotp,
			BindingResult result,
			@ModelAttribute("signin")SignIn signin,
			@ModelAttribute("forgotPassword")ForgotPassword forgotPassword,
			@ModelAttribute("changePassword") ChangePassword changePassword) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("SignIn");
			mv.addObject("otpModal", "Message");
			return mv;
		}
		
		if(otp != useotp.getOtp()) {
			mv.setViewName("SignIn");
			mv.addObject("otpModal", "Error");
			mv.addObject("otpError","Invalid OTP, Please try later");
			return mv;
		}else {
			mv.setViewName("SignIn");
			mv.addObject("resetModal", "Message");
			return mv;
		}
	}
	
	@PostMapping("ResetPassword")
	public ModelAndView resetPassword(@Valid @ModelAttribute("changePassword") ChangePassword changePassword,
			BindingResult result,
			@ModelAttribute("signin")SignIn signin,
			@ModelAttribute("forgotPassword")ForgotPassword forgotPassword,
			@ModelAttribute("otp")OTP otpObj) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("SignIn");
			mv.addObject("resetModal", "Error");
			return mv;
		}
	
		if(!(changePassword.getNew_pwd().equalsIgnoreCase(changePassword.getConfirm_pwd()))) {
			mv.setViewName("SignIn");
			mv.addObject("resetModal", "Error");
			mv.addObject("passwordMismatch", "Error");
			return mv;
		}
		
		userService.updatePassword(changePassword.getNew_pwd(),changePassword.getId());
		
		mv.setViewName("redirect:/SignIn");
		mv.addObject("updated", "Success");
		return mv;
	}
	
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
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("ChangePassword");
			return mv;
		}
	
		if(!(changePassword.getNew_pwd().equalsIgnoreCase(changePassword.getConfirm_pwd()))) {
			mv.setViewName("ChangePassword");
			mv.addObject("passwordMismatch", "Error");
			return mv;
		}
		
		userService.updatePassword(changePassword.getNew_pwd(),changePassword.getId());
		
		mv.setViewName("redirect:/ChangePassword");
		mv.addObject("updated", "Success");
		return mv;
	}

	@GetMapping("Experience")
	public ModelAndView getStateMaster(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "updated", required = false) String updated,
			@RequestParam(value = "deleted", required = false) String deleted) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (!(added == null))
			mv.addObject("added", "success");
		if (!(updated == null))
			mv.addObject("updated", "success");
		if (!(deleted == null))
			mv.addObject("deleted", "success");

		mv.setViewName("Experience");
		mv.addObject("exp", new ExperienceValidation());
		mv.addObject("pagedListHolder", masterController.pagination(expService.selectAllByUserId(session.getAttribute("id")), request));
		return mv;
	}
	
	public Period ExperienceCalculator(String from_date, String to_date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String firstInput = from_date;
		String secondInput = to_date;
		LocalDate firstDate = LocalDate.parse(firstInput, formatter);
		LocalDate secondDate = LocalDate.parse(secondInput, formatter);
		Period diff = Period.between(firstDate, secondDate);
		return diff;
	}
	
	@PostMapping("SaveExperience")
	public ModelAndView saveExperience(@Valid @ModelAttribute("exp") ExperienceValidation exp, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("Experience");
			mv.addObject("addError", "error");
			mv.addObject("pagedListHolder", masterController.pagination(expService.selectAllByUserId(session.getAttribute("id")), request));
			return mv;
		}
		        
		Period diff = ExperienceCalculator(exp.getFrom_date(),exp.getTo_date());
        
		Experience e = new Experience();
        
        e.setDiff_years(diff.getYears());
        e.setDiff_months(diff.getMonths());
        e.setDiff_days(diff.getDays() + 1 );
        e.setInn(exp.isInn());

        expService.saveExperience(exp.getUser_id(),exp.getInstitute_name(),exp.getDesignation(),exp.getFrom_date(),exp.getTo_date(),e.getDiff_years(),e.getDiff_months(),e.getDiff_days(),e.getInn());

		mv.setViewName("redirect:/Experience");
		mv.addObject("added", "Success Message");
		return mv;
	}

	@PostMapping("EditExperience")
	public ModelAndView editExperience(@Valid @ModelAttribute("exp") ExperienceValidation exp, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.addObject("editError", "error");
			mv.addObject("pagedListHolder", masterController.pagination(expService.selectAllByUserId(session.getAttribute("id")), request));
			mv.setViewName("Experience");
			return mv;
		}
		
		Period diff = ExperienceCalculator(exp.getFrom_date(),exp.getTo_date());
		
        Experience e = new Experience();
      
        e.setDiff_years(diff.getYears());
        e.setDiff_months(diff.getMonths());
        e.setDiff_days(diff.getDays() + 1);
        e.setInn(exp.isInn());
        		
		expService.updateExperience(exp.getId(), exp.getInstitute_name(), exp.getDesignation(), exp.getFrom_date(), exp.getTo_date(), e.getDiff_years(), e.getDiff_months(), e.getDiff_days(), e.getInn());;

		mv.setViewName("redirect:/Experience");
		mv.addObject("updated", "success");
		return mv;
	}

	@PostMapping("DeleteExperience")
	public ModelAndView deleteExperience(@RequestParam("id") int id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		expService.updateInnZero(id, 0);
		
		mv.setViewName("redirect:/Experience");
		mv.addObject("deleted", "success");
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
}