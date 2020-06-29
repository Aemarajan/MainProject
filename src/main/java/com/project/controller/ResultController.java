package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.External;
import com.project.service.AcademicMappingService;
import com.project.service.DDSService;
import com.project.service.ExternalService;
import com.project.service.RSSMappingService;
import com.project.service.StudSubMappingService;
import com.project.service.SyllabusService;

@Controller
public class ResultController {

	@Autowired
	SyllabusService sylService;
	
	@Autowired
	RSSMappingService rssService;
	
	@Autowired
	DDSService ddsService;
	
	@Autowired
	AcademicMappingService acaService;
	
	@Autowired
	StudSubMappingService ssmService;
	
	@Autowired
	ExternalService extService;
	
	double gpa,cgpa;
	
	public double gpaCaluculator() {
		
		return gpa;
	}
	
	public double cgpaCalculator() {
		
		return cgpa;
	}
	
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
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user") int user,@RequestParam(value="sem") int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester1");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem) );
		return mv;
	}
	
	@PostMapping("SaveSemester1")
	public ModelAndView saveSemester1(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
//		if(result.hasErrors()) {
//			mv.setViewName("Semester1");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester1");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());
	
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("Semester2")
	public ModelAndView getSemester2(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user")int user,@RequestParam(value="sem")int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester2");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
		return mv;
	}
	
	@PostMapping("SaveSemester2")
	public ModelAndView saveSemester2(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

//		if(result.hasErrors()) {
//			mv.setViewName("Semester2");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester2");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());

		
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("Semester3")
	public ModelAndView getSemester3(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user")int user,@RequestParam(value="sem")int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester3");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
		return mv;
	}
	
	@PostMapping("SaveSemester3")
	public ModelAndView saveSemester3(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
//		if(result.hasErrors()) {
//			mv.setViewName("Semester3");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester3");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());

		
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("Semester4")
	public ModelAndView getSemester4(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user")int user,@RequestParam(value="sem")int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester4");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
		return mv;
	}
	
	@PostMapping("SaveSemester4")
	public ModelAndView saveSemester4(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
//		if(result.hasErrors()) {
//			mv.setViewName("Semester4");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester4");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());

		
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("Semester5")
	public ModelAndView getSemester5(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user")int user,@RequestParam(value="sem")int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester5");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
		return mv;
	}
	
	@PostMapping("SaveSemester5")
	public ModelAndView saveSemester5(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
//		if(result.hasErrors()) {
//			mv.setViewName("Semester5");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester5");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());

		
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}
	
	@GetMapping("Semester6")
	public ModelAndView getSemester6(HttpSession session, HttpServletRequest request,
			@RequestParam(value="added", required=false) String added,
			@RequestParam(value="user")int user,@RequestParam(value="sem")int sem ) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		if(!(added == null))
			mv.addObject("added", "Success");
		
		mv.setViewName("Semester6");
		//mv.addObject("external", new ExternalValidation());
		mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
		return mv;
	}
	
	@PostMapping("SaveSemester6")
	public ModelAndView saveSemester6(External ex,HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
//		if(result.hasErrors()) {
//			mv.setViewName("Semester6");
//			mv.addObject("subject", ssmService.selectAllSubjectsByUserId(user,sem));
//			return mv;
//		}
		
		List<External> list = extService.selectAll();	
		
		for(External e : list) {
			if( (e.getUser() == ex.getUser()) && (e.getSemester().getId() == ex.getSemester().getId()) ) {
				mv.setViewName("Semester6");
				mv.addObject("subject", ssmService.selectAllSubjectsByUserId(ex.getUser().getUser_id(),ex.getSemester().getId()));
				mv.addObject("exist", "Error");
				return mv;
			}
		}
		
		extService.saveExternalMarks(
				ex.getUser(),ex.getSemester(),ex.getMa5161(),
				ex.getMc5101(),ex.getMc5102(),ex.getMc5103(),ex.getMc5104(),
				ex.getMc5111(),ex.getMc5112(),ex.getMc5113(),
				ex.getMc5201(),ex.getMc5202(),ex.getMc5203(),ex.getMc5204(),ex.getMc5205(),
				ex.getMc5211(),ex.getMc5212(),ex.getMc5213(),
				ex.getMc5301(),ex.getMc5302(),ex.getMc5303(),ex.getMc5304(),ex.getMc5305(),
				ex.getMc5311(),ex.getMc5312(),ex.getMc5313(),
				ex.getMc5401(),ex.getMc5402(),ex.getMc5403(),ex.getMc5404(),
				ex.getMc5001(),ex.getMc5002(),ex.getMc5003(),ex.getMc5004(),ex.getMc5005(),
				ex.getMc5411(),ex.getMc5412(),ex.getMc5413(),
				ex.getMc5501(),ex.getMc5502(),ex.getMc5503(),
				ex.getMc5006(),ex.getMc5007(),ex.getMc5008(),ex.getMc5009(),ex.getMc5010(),
				ex.getMc5011(),ex.getMc5012(),ex.getMc5013(),ex.getMc5014(),ex.getMc5015(),
				ex.getMc5511(),ex.getMc5512(),ex.getMc5513(),
				ex.getMc5611(),
				ex.getGpa(),ex.getCgpa(),ex.getInn());

		
		mv.setViewName("redirect:/AddExternal");
		mv.addObject("added", "Success");
		return mv;
	}

	//Admin View
	
	@PostMapping("AdminViewExternalMarks")
	public ModelAndView viewExternalMarks1(HttpSession session,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		int batch = Integer.parseInt(request.getParameter("batch"));
		int regulation = Integer.parseInt(request.getParameter("regulation"));
		int year = Integer.parseInt(request.getParameter("year"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		int section = Integer.parseInt(request.getParameter("section"));
		
		mv.setViewName("ViewExternalMarks1");
		mv.addObject("AdminViewStudents", acaService.selectAllStudentsByBRYSS(batch,regulation,year,semester,section));
		return mv;
	}
	
	@GetMapping("AdminViewSemMarks")
	public ModelAndView viewExternalmarks2(HttpSession session,HttpServletRequest request,
			@RequestParam(value="user") int user) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		mv.setViewName("ViewExternalMarks2");
		mv.addObject("sem1sub", ssmService.selectAllSubjectsByUserId(user, 1));
		mv.addObject("sem2sub", ssmService.selectAllSubjectsByUserId(user, 2));
		mv.addObject("sem3sub", ssmService.selectAllSubjectsByUserId(user, 3));
		mv.addObject("sem4sub", ssmService.selectAllSubjectsByUserId(user, 4));
		mv.addObject("sem5sub", ssmService.selectAllSubjectsByUserId(user, 5));
		mv.addObject("sem6sub", ssmService.selectAllSubjectsByUserId(user, 6));
		
		mv.addObject("sem1", extService.SelectSemesterMarks(1, user));
		mv.addObject("sem2", extService.SelectSemesterMarks(2, user));
		mv.addObject("sem3", extService.SelectSemesterMarks(3, user));
		mv.addObject("sem4", extService.SelectSemesterMarks(4, user));
		mv.addObject("sem5", extService.SelectSemesterMarks(5, user));
		mv.addObject("sem6", extService.SelectSemesterMarks(6, user));
		return mv;
	}
	
	//Staff View
	
	@GetMapping("StaffViewSemMarks")
	public ModelAndView viewExternalMarks3(HttpSession session,HttpServletRequest request,
			@RequestParam(value="user") int user) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		
		mv.setViewName("ViewExternalMarks2");
		mv.addObject("sem1sub", ssmService.selectAllSubjectsByUserId(user, 1));
		mv.addObject("sem2sub", ssmService.selectAllSubjectsByUserId(user, 2));
		mv.addObject("sem3sub", ssmService.selectAllSubjectsByUserId(user, 3));
		mv.addObject("sem4sub", ssmService.selectAllSubjectsByUserId(user, 4));
		mv.addObject("sem5sub", ssmService.selectAllSubjectsByUserId(user, 5));
		mv.addObject("sem6sub", ssmService.selectAllSubjectsByUserId(user, 6));
		
		mv.addObject("sem1", extService.SelectSemesterMarks(1, user));
		mv.addObject("sem2", extService.SelectSemesterMarks(2, user));
		mv.addObject("sem3", extService.SelectSemesterMarks(3, user));
		mv.addObject("sem4", extService.SelectSemesterMarks(4, user));
		mv.addObject("sem5", extService.SelectSemesterMarks(5, user));
		mv.addObject("sem6", extService.SelectSemesterMarks(6, user));
		
		//System.out.println(ssmService.selectAllSubjectsByUserId(user, 4));
		//System.out.println(extService.SelectSemesterMarks(4, user));
		
		return mv;
	}
	
	//Student View 
	
	@GetMapping("ViewExternal")
	public ModelAndView viewExternalMarks4(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		int user_id = (int) session.getAttribute("id");
		// String user_role = (String) session.getAttribute("role");

		mv.setViewName("ViewExternalMarks");
		mv.addObject("sem1sub", ssmService.selectAllSubjectsByUserId(user_id, 1));
		mv.addObject("sem2sub", ssmService.selectAllSubjectsByUserId(user_id, 2));
		mv.addObject("sem3sub", ssmService.selectAllSubjectsByUserId(user_id, 3));
		mv.addObject("sem4sub", ssmService.selectAllSubjectsByUserId(user_id, 4));
		mv.addObject("sem5sub", ssmService.selectAllSubjectsByUserId(user_id, 5));
		mv.addObject("sem6sub", ssmService.selectAllSubjectsByUserId(user_id, 6));
		
		mv.addObject("sem1", extService.SelectSemesterMarks(1, user_id));
		mv.addObject("sem2", extService.SelectSemesterMarks(2, user_id));
		mv.addObject("sem3", extService.SelectSemesterMarks(3, user_id));
		mv.addObject("sem4", extService.SelectSemesterMarks(4, user_id));
		mv.addObject("sem5", extService.SelectSemesterMarks(5, user_id));
		mv.addObject("sem6", extService.SelectSemesterMarks(6, user_id));
		return mv;
	}
}