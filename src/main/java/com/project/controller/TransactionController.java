package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.customvalidator.AcademicValidation;
import com.project.customvalidator.AddDDS;
import com.project.customvalidator.CSDMappingValidation;
import com.project.customvalidator.RSSMappingValidation;
import com.project.customvalidator.SSMappingValidation;
import com.project.customvalidator.StudSubMappingValidation;
import com.project.model.AcademicMapping;
import com.project.model.CSDMapping;
import com.project.model.DDSMapping;
import com.project.model.RSSMapping;
import com.project.model.SSMapping;
import com.project.model.StudSubMapping;
import com.project.service.AcademicMappingService;
import com.project.service.BatchService;
import com.project.service.CSDService;
import com.project.service.CountryService;
import com.project.service.DDSService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;
import com.project.service.DistrictService;
import com.project.service.RSSMappingService;
import com.project.service.RegulationService;
import com.project.service.SSMappingService;
import com.project.service.SectionService;
import com.project.service.SemesterService;
import com.project.service.StateService;
import com.project.service.StudSubMappingService;
import com.project.service.SyllabusService;
import com.project.service.UserService;
import com.project.service.YearService;

@RestController
public class TransactionController {

	@Autowired
	UserService userService;

	@Autowired
	MasterController masterController;

	@Autowired
	CountryService countryService;

	@Autowired
	StateService stateService;

	@Autowired
	DistrictService districtService;

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

	@Autowired
	SyllabusService syllabusService;

	@Autowired
	CSDService csdService;

	@Autowired
	SSMappingService ssService;

	@Autowired
	DDSService ddsService;

	@Autowired
	RSSMappingService rssService;

	@Autowired
	AcademicMappingService acaService;

	@Autowired
	StudSubMappingService ssmService;

	@GetMapping("CSDMapping")
	public ModelAndView getCSDMapping(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "inactive", required = false) String inactive,
			@RequestParam(value = "active", required = false) String active) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "Success");
		if (!(inactive == null))
			mv.addObject("inactive", "Success");
		if (!(active == null))
			mv.addObject("active", "Success");

		mv.setViewName("CSDMapping");
		mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
		mv.addObject("csdMapping", new CSDMappingValidation());
		return mv;
	}

	@PostMapping("SaveCSDMapping")
	public ModelAndView saveCSDMapping(@Valid @ModelAttribute("csdMapping") CSDMappingValidation csd,
			BindingResult result, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("CSDMapping");
			mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
			mv.addObject("addError", "Error");
			return mv;
		}

		List<CSDMapping> list = csdService.selectAll();

		for (CSDMapping c : list) {
			if ((c.getDistrict().getId()) == csd.getDistrict()) {
				mv.setViewName("CSDMapping");
				mv.addObject("pagedListHolder", masterController.pagination(csdService.selectAll(), request));
				mv.addObject("addError", "Error");
				mv.addObject("addExist", "Error");
				return mv;
			}
		}

		csdService.save(new CSDMapping(csd.getId(), countryService.selectById((Integer) csd.getCountry()),
				stateService.selectById(csd.getState()), districtService.selectById(csd.getDistrict()),
				csd.isInn() ? 1 : 0));
		mv.setViewName("redirect:/CSDMapping");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("changeStatusInCSD")
	public ModelAndView changeCSDStatus(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		CSDMapping c = csdService.selectById(id);

		if (c.getInn() == 1) {
			csdService.updateInn(id, 0);
			mv.setViewName("redirect:/CSDMapping");
			mv.addObject("inactive", "Success");
		}
		if (c.getInn() == 0) {
			csdService.updateInn(id, 1);
			mv.setViewName("redirect:/CSDMapping");
			mv.addObject("active", "Success");
		}
		return mv;
	}

	@GetMapping("GetDDSMapping")
	public ModelAndView getDDSMapping(@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "active", required = false) String active,
			@RequestParam(value = "inactive", required = false) String inactive, HttpSession session,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "success");
		if (!(active == null))
			mv.addObject("active", "success");
		if (!(inactive == null))
			mv.addObject("inactive", "success");

		mv.setViewName("DDSMapping");
		mv.addObject("pagedListHolder", masterController.pagination(ddsService.selectAll(), request));
		mv.addObject("dds", new AddDDS());
		return mv;
	}

	@PostMapping("SaveDDSMapping")
	public ModelAndView saveDDSMapping(@Valid @ModelAttribute("dds") AddDDS dds, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("DDSMapping");
			mv.addObject("pagedListHolder", masterController.pagination(ddsService.selectAll(), request));
			mv.addObject("addError", "error");
			return mv;
		}
		DDSMapping exist = ddsService.selectByAllId(dds.getDegree(), dds.getDepartment(), dds.getSection());

		if (!(exist == null)) {
			mv.setViewName("DDSMapping");
			mv.addObject("pagedListHolder", masterController.pagination(ddsService.selectAll(), request));
			mv.addObject("addError", "error");
			mv.addObject("addExist", "exist");
			return mv;
		}

		ddsService.save(batchService.selectById(dds.getBatch()), regulationService.selectById(dds.getRegulation()),
				degreeService.selectById(dds.getDegree()), departmentService.selectById(dds.getDepartment()),
				yearService.selectById(dds.getYear()), semesterService.selectById(dds.getSemester()),
				sectionService.selectById(dds.getSection()), dds.isInn() ? 1 : 0);

		mv.setViewName("redirect:/GetDDSMapping");
		mv.addObject("added", "success");
		return mv;
	}

	@GetMapping("changeStatusInDDS")
	public ModelAndView changeStatusInDDS(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:/GetDDSMapping");

		DDSMapping c = ddsService.selectById(id);

		if (c.getInn() == 1) {
			ddsService.updateInn(id, 0);
			mv.addObject("inactive", "success");
		}

		if (c.getInn() == 0) {
			ddsService.updateInn(id, 1);
			mv.addObject("active", "success");
		}
		return mv;
	}

	@GetMapping("SSMapping")
	public ModelAndView getSSMapping(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "inactive", required = false) String inactive,
			@RequestParam(value = "active", required = false) String active) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "Success");
		if (!(inactive == null))
			mv.addObject("inactive", "Success");
		if (!(active == null))
			mv.addObject("active", "Success");

		mv.setViewName("SSMapping");
		mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
		mv.addObject("ssMapping", new SSMappingValidation());
		return mv;
	}

	@PostMapping("SaveSSMapping")
	public ModelAndView saveSSMapping(@Valid @ModelAttribute("ssMapping") SSMappingValidation ss, BindingResult result,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("SSMapping");
			mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
			mv.addObject("addError", "Error");
			return mv;
		}

		List<SSMapping> list = ssService.selectAll();

		for (SSMapping s : list) {
			if ((s.getStudent().getUser_id()) == ss.getStudent()) {
				mv.setViewName("SSMapping");
				mv.addObject("pagedListHolder", masterController.pagination(ssService.selectAll(), request));
				mv.addObject("addError", "Error");
				mv.addObject("addExist", "Error");
				return mv;
			}
		}

		ssService.save(new SSMapping(ss.getId(), userService.selectById((Integer) ss.getStaff()),
				userService.selectById(ss.getStudent()), ss.isInn() ? 1 : 0));

		mv.setViewName("redirect:/SSMapping");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("changeStatusInSSMapping")
	public ModelAndView changeSSMappingStatus(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		SSMapping s = ssService.selectById(id);

		if (s.getInn() == 1) {
			ssService.updateInn(id, 0);
			mv.setViewName("redirect:/SSMapping");
			mv.addObject("inactive", "Success");
		}
		if (s.getInn() == 0) {
			ssService.updateInn(id, 1);
			mv.setViewName("redirect:/SSMapping");
			mv.addObject("active", "Success");
		}
		return mv;
	}

	@GetMapping("GetRSSMapping")
	public ModelAndView getRSMapping(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "inactive", required = false) String inactive,
			@RequestParam(value = "active", required = false) String active) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "Success");
		if (!(active == null))
			mv.addObject("active", "Success");
		if (!(inactive == null))
			mv.addObject("inactive", "Success");

		mv.setViewName("RSSMapping");
		mv.addObject("pagedListHolder", masterController.pagination(rssService.selectAll(), request));
		mv.addObject("RSSMapping", new RSSMappingValidation());
		return mv;
	}

	@PostMapping("SaveRSSMapping")
	public ModelAndView saveRSSmapping(@Valid @ModelAttribute("RSSMapping") RSSMappingValidation rss,
			BindingResult result, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("RSSMapping");
			mv.addObject("addError", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(rssService.selectAll(), request));
			return mv;
		}

		List<RSSMapping> list = rssService.selectAll();

		for (RSSMapping rs : list) {
			if ((rs.getSubject().getId()) == rss.getSubject()) {
				mv.setViewName("RSSMapping");
				mv.addObject("pagedListHolder", masterController.pagination(rssService.selectAll(), request));
				mv.addObject("exist", "Error");
				mv.addObject("addError", "Error");
				return mv;
			}
		}

		rssService.save(new RSSMapping(regulationService.selectById((Integer) rss.getRegulation()),
				semesterService.selectById((Integer) rss.getSemester()),
				syllabusService.selectById((Integer) rss.getSubject()), rss.isInn() ? 1 : 0));

		mv.setViewName("redirect:/GetRSSMapping");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("changeStatusInRSSMapping")
	public ModelAndView changeRSSMappingStatus(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		RSSMapping s = rssService.selectById(id);

		if (s.getInn() == 1) {
			rssService.updateInn(id, 0);
			mv.setViewName("redirect:/RSSMapping");
			mv.addObject("inactive", "Success");
		}
		if (s.getInn() == 0) {
			rssService.updateInn(id, 1);
			mv.setViewName("redirect:/RSSMapping");
			mv.addObject("active", "Success");
		}
		return mv;
	}

	@GetMapping("AcademicMapping")
	public ModelAndView getAcademicMappingStart(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "inactive", required = false) String inactive,
			@RequestParam(value = "active", required = false) String active) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "Success");
		if (!(active == null))
			mv.addObject("active", "Success");
		if (!(inactive == null))
			mv.addObject("inactive", "Success");

		mv.setViewName("AcademicMapping");
		mv.addObject("pagedListHolder", masterController.pagination(acaService.selectAll(), request));
		mv.addObject("Academic", new AcademicValidation());
		return mv;
	}

	@PostMapping("SaveAcademicMapping")
	public ModelAndView saveAcademicMapping(@Valid @ModelAttribute("Academic") AcademicValidation aca,
			BindingResult result, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("AcademicMapping");
			mv.addObject("pagedListHolder", masterController.pagination(acaService.selectAll(), request));
			mv.addObject("addError", "Error");
			return mv;
		}

		List<AcademicMapping> amexist = acaService.selectAll();

		for (AcademicMapping am : amexist) {
			if ((am.getUser().getUser_id()) == aca.getUser()) {
				mv.setViewName("AcademicMapping");
				mv.addObject("addError", "Error");
				mv.addObject("pagedListHolder", masterController.pagination(acaService.selectAll(), request));
				mv.addObject("addExist", "Error");
				return mv;
			}
		}

		List<DDSMapping> ddsexist = ddsService.checkDDSCombo(aca.getBatch(), aca.getRegulation(), aca.getDegree(),
				aca.getDepartment(), aca.getYear(), aca.getSemester(), aca.getSection());

		if (ddsexist.isEmpty()) {
			mv.setViewName("AcademicMapping");
			mv.addObject("addError", "Error");
			mv.addObject("DDSMismatch", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(acaService.selectAll(), request));
			return mv;
		}

		AcademicMapping acdm = new AcademicMapping();
		acdm.setStatus(1);

		acaService.save(userService.selectById(aca.getUser()), batchService.selectById(aca.getBatch()),
				regulationService.selectById(aca.getRegulation()), degreeService.selectById(aca.getDegree()),
				departmentService.selectById(aca.getDepartment()), yearService.selectById(aca.getYear()),
				semesterService.selectById(aca.getSemester()), sectionService.selectById(aca.getSection()),
				acdm.getStatus(), aca.isInn() ? 1 : 0);

		mv.setViewName("redirect:/AcademicMapping");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("changeStatusInACAMapping")
	public ModelAndView changeStatusInACAMapping(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		AcademicMapping s = acaService.selectById(id);

		if (s.getInn() == 1) {
			acaService.updateInn(id, 0);
			mv.setViewName("redirect:/AcademicMapping");
			mv.addObject("inactive", "Success");
		}
		if (s.getInn() == 0) {
			acaService.updateInn(id, 1);
			mv.setViewName("redirect:/AcademicMapping");
			mv.addObject("active", "Success");
		}
		return mv;
	}

	@GetMapping("GetStudSubMapping")
	public ModelAndView getStudSubMapping(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "added", required = false) String added,
			@RequestParam(value = "inactive", required = false) String inactive,
			@RequestParam(value = "active", required = false) String active) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (!(added == null))
			mv.addObject("added", "Success");
		if (!(active == null))
			mv.addObject("active", "Success");
		if (!(inactive == null))
			mv.addObject("inactive", "Success");

		mv.setViewName("StudSubMapping");
		mv.addObject("pagedListHolder", masterController.pagination(ssmService.selectAll(), request));
		mv.addObject("StudSubMapping", new StudSubMappingValidation());
		return mv;
	}

	@PostMapping("SaveStudSubMapping")
	public ModelAndView saveStudSubMapping(@Valid @ModelAttribute("StudSubMapping") StudSubMappingValidation ssm,
			BindingResult result, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "Expired");
			return mv;
		}

		if (result.hasErrors()) {
			mv.setViewName("StudSubMapping");
			mv.addObject("addError", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(ssmService.selectAll(), request));
			return mv;
		}

		List<RSSMapping> ssmexist = rssService.checkRSSCombo(ssm.getRegulation(), ssm.getSemester(), ssm.getSubject());

		if (ssmexist.isEmpty()) {
			mv.setViewName("StudSubMapping");
			mv.addObject("addError", "Error");
			mv.addObject("SSMMismatch", "Error");
			mv.addObject("pagedListHolder", masterController.pagination(ssmService.selectAll(), request));
			return mv;
		}

		ssmService.save( new StudSubMapping(
		  userService.selectById((Integer)ssm.getUser()),
		  regulationService.selectById((Integer)ssm.getRegulation()),
		  semesterService.selectById((Integer)ssm.getSemester()),
		  syllabusService.selectById((Integer)ssm.getSubject()), ssm.isInn() ? 1 : 0
		  ));
		 

		mv.setViewName("redirect:/GetStudSubMapping");
		mv.addObject("added", "Success");
		return mv;
	}

	@GetMapping("changeStatusInStudSub")
	public ModelAndView changeStudSubMappingStatus(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		StudSubMapping s = ssmService.selectById(id);

		if (s.getInn() == 1) {
			ssmService.updateInn(id, 0);
			mv.setViewName("redirect:/GetStudSubMapping");
			mv.addObject("inactive", "Success");
		}
		if (s.getInn() == 0) {
			ssmService.updateInn(id, 1);
			mv.setViewName("redirect:/GetStudSubMapping");
			mv.addObject("active", "Success");
		}
		return mv;
	}
}