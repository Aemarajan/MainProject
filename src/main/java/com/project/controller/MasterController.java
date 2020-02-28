package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Batch;
import com.project.model.Bloodgroup;
import com.project.model.Community;
import com.project.model.Country;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.Diploma;
import com.project.model.District;
import com.project.model.Grade;
import com.project.model.Regulation;
import com.project.model.Religion;
import com.project.model.State;
import com.project.service.BatchService;
import com.project.service.BloodgroupService;
import com.project.service.CommunityService;
import com.project.service.CountryService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;
import com.project.service.DiplomaService;
import com.project.service.DistrictService;
import com.project.service.GradeService;
import com.project.service.LanguageService;
import com.project.service.MPhilService;
import com.project.service.PGService;
import com.project.service.RegulationService;
import com.project.service.ReligionService;
import com.project.service.StateService;
import com.project.validator.AddBatchMaster;
import com.project.validator.AddBloodGroup;
import com.project.validator.AddCommunity;
import com.project.validator.AddCountry;
import com.project.validator.AddDegree;
import com.project.validator.AddRegulation;
import com.project.validator.AddReligion;
import com.project.validator.AddDepartment;

@Controller
public class MasterController {

	@Autowired
	BatchService batchService;
	
	@Autowired
	BloodgroupService bloodgroupService;
	
	@Autowired
	CommunityService communityService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	DegreeService degreeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DiplomaService diplomaService;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	GradeService gradeService;
	
	@Autowired
	RegulationService regulationService;
	
	@Autowired
	LanguageService languageService;
	
	@Autowired
	MPhilService mphilService;
	
	@Autowired
	PGService pgService;
	
	@Autowired
	ReligionService religionService;
	
	@GetMapping("GetBatchMaster")
	public ModelAndView getBatchMaster(@RequestParam(value="updated",required=false)String updated,@RequestParam(value="added",required=false)String added,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.addObject("list", batchService.selectAll());
		mv.addObject("addBatch", new AddBatchMaster());
		mv.setViewName("BatchMaster");
		return mv;
	}
	
	@PostMapping("SaveBatchMaster")
	public ModelAndView saveBatchMaster(@Valid @ModelAttribute("addBatch") AddBatchMaster batch,BindingResult result ,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.addObject("session", "destroy");
			mv.setViewName("redirect:/logout");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("BatchMaster");
			mv.addObject("list", batchService.selectAll());
			mv.addObject("addError", "error");
			return  mv;
		}
		Batch exist = batchService.selectBatchByFromTo(Integer.parseInt(batch.getFrom_year()),Integer.parseInt(batch.getTo_year()));
		if(exist != null) {
			mv.setViewName("BatchMaster");
			mv.addObject("list", batchService.selectAll());
			mv.addObject("addError", "error");
			mv.addObject("addExist", "already exist");
			return mv;
		}
		int f_year = Integer.parseInt(batch.getFrom_year());
		int t_year = Integer.parseInt(batch.getTo_year());
		int n_year = t_year - f_year;
		
		if(n_year<=4 && n_year>=2) {
			Batch bm = new Batch();
			bm.setFrom_year(f_year);
			bm.setTo_year(t_year);
			bm.setNo_of_years(n_year);		
			bm.setInn(batch.isInn());
			batchService.saveBatchMaster(bm);
			mv.setViewName("BatchMaster");
			mv.addObject("list", batchService.selectAll());
			mv.addObject("added", "Success Message");
			return mv;
		}
		mv.setViewName("BatchMaster");
		mv.addObject("list", batchService.selectAll());
		mv.addObject("addError", "error");
		mv.addObject("addInvalidYear", "Invalid year");
		return mv;
	}
	
	@PostMapping("EditBatch")
	public ModelAndView editBatch(@Valid @ModelAttribute("addBatch")AddBatchMaster batch,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.addObject("session", "destroy");
			mv.setViewName("redirect:/logout");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("BatchMaster");
			mv.addObject("list", batchService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Batch> list = batchService.selectAllExceptId(batch.getId());
		for(Batch b: list) {
			if(b.getFrom_year() == Integer.parseInt(batch.getFrom_year()) && b.getTo_year() == Integer.parseInt(batch.getTo_year())) {
				mv.setViewName("BatchMaster");
				mv.addObject("list",batchService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExist", "already exist");
				return mv;
			}
		}
		Batch exist = batchService.selectBatchByFromTo(Integer.parseInt(batch.getFrom_year()),Integer.parseInt(batch.getTo_year()),batch.isInn()?1:0);
		if(exist != null) {
			mv.setViewName("BatchMaster");
			mv.addObject("list",batchService.selectAll());
			mv.addObject("editError", "error");
			mv.addObject("editExist", "already exist");
			return mv;
		}
		int f_year = Integer.parseInt(batch.getFrom_year());
		int t_year = Integer.parseInt(batch.getTo_year());
		int n_year = t_year - f_year;
		if(n_year<=4 && n_year>=2) {
			Batch bm = new Batch();		
			bm.setInn(batch.isInn());
			batchService.updateBatchMaster(batch.getId(),f_year,t_year,n_year,bm.getInn());
			mv.setViewName("BatchMaster");
			mv.addObject("updated", "Success");
			mv.addObject("list",batchService.selectAll());
			return mv;
		}
		mv.setViewName("BatchMaster");
		mv.addObject("list",batchService.selectAll());
		mv.addObject("editError", "error");
		mv.addObject("editInvalidYear", "Invalid year");
		return mv;
	}
	
	@PostMapping("DeleteBatch")
	public ModelAndView deleteBatch(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		batchService.updateInnZero(id);
		mv.setViewName("redirect:/GetBatchMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetBloodGroupMaster")
	public ModelAndView getBloodroupMaster(@RequestParam(value="added",required=false)String added,@RequestParam(value="updated",required=false)String updated,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(session.getAttribute("id") == null) {
			model.addObject("session", "destroy");
			model.setViewName("redirect:/logout");
			return model;
		}
		if(!(added == null))
			model.addObject("added", "success");
		if(!(updated == null))
			model.addObject("updated", "success");
		if(!(deleted == null))
			model.addObject("deleted", "success");
		model.setViewName("BloodGroupMaster");
		model.addObject("list", bloodgroupService.selectAll());
		model.addObject("bloodgroup", new AddBloodGroup());
		return model;
	}
	
	@PostMapping("SaveBloodGroupMaster")
	public ModelAndView saveBloodgroupMaster(@Valid @ModelAttribute("bloodgroup") AddBloodGroup blood,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("BloodGroupMaster");
			mv.addObject("list", bloodgroupService.selectAll());
			mv.addObject("addError", "error");
			return  mv;
		}
		List<Bloodgroup> list = bloodgroupService.selectAll();
		for(Bloodgroup b : list) {
			if(b.getName().contentEquals(blood.getName())) {
				mv.setViewName("BloodGroupMaster");
				mv.addObject("list", bloodgroupService.selectAll());
				mv.addObject("addExist", "error");
				mv.addObject("addError", "error");
				return  mv;
			}
		}
		Bloodgroup bm = new Bloodgroup();
		bm.setName((blood.getName().toUpperCase()).replaceAll("\\s", ""));
		bm.setInn(blood.isInn());
		bloodgroupService.saveBloodgroupMaster(bm);
			
		mv.setViewName("BloodGroupMaster");
		mv.addObject("list", bloodgroupService.selectAll());
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@PostMapping("EditBloodGroup")
	public ModelAndView editBloodGroup(@Valid @ModelAttribute("bloodgroup")AddBloodGroup blood,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("BloodGroupMaster");
			mv.addObject("list", bloodgroupService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Bloodgroup> list = bloodgroupService.selectAllExceptId(blood.getId());
		for(Bloodgroup b : list) {
			if(b.getName().equalsIgnoreCase(blood.getName().replaceAll("\\s", ""))) {
				mv.setViewName("BloodGroupMaster");
				mv.addObject("list", bloodgroupService.selectAll());
				mv.addObject("editExist", "error");
				mv.addObject("editError", "error");
				return mv;			
			}
		}
		bloodgroupService.updateBloodgroup(blood.getId(), blood.getName().toUpperCase().replaceAll("\\s", ""), blood.isInn()?1:0);
		mv.setViewName("redirect:/GetBloodGroupMaster");
		mv.addObject("updated", "Success Message");
		return mv;
	}
	
	@PostMapping("DeleteBloodGroup")
	public ModelAndView deleteBloodGroup(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		bloodgroupService.updateInnZero(id);
		mv.setViewName("redirect:/GetBloodGroupMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetCommunityMaster")
	public ModelAndView getCommunityMaster(@RequestParam(value="updated",required=false)String update,@RequestParam(value="added",required=false)String added,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		mv.addObject("list", communityService.selectAll());
		mv.addObject("community", new AddCommunity());
		if(!(update == null))
			mv.addObject("updated", "success");
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.setViewName("CommunityMaster");
		return mv;
	}
	
	@PostMapping("SaveCommunityMaster")
	public ModelAndView saveCommunityMaster(@Valid @ModelAttribute("community") AddCommunity comm,BindingResult result,HttpSession session,ModelMap model) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("CommunityMaster");
			mv.addObject("list", communityService.selectAll());
			mv.addObject("addError", "Error in add");
			return mv;
		}
		if(session.getAttribute("id") == null) {
			mv.addObject("session", "destroy");
			mv.setViewName("redirect:/logout");
			return mv;
		}
		Community exist1 = communityService.selectByCommunity(comm.getName().toLowerCase());
		if(exist1 != null) {
			mv.setViewName("CommunityMaster");
			mv.addObject("list", communityService.selectAll());
			mv.addObject("addError", "Error in add");
			mv.addObject("addExistCommunity", "already exist");
			return mv;
		}
		Community exist = communityService.selectByAcronym(comm.getAcronym().toUpperCase());
		if(exist != null) {
			mv.setViewName("CommunityMaster");
			mv.addObject("list", communityService.selectAll());
			mv.addObject("addError", "Error in add");
			mv.addObject("addExistAcronym", "already exist");
			return mv;
		}
		Community cm = new Community();
		cm.setName(comm.getName().toLowerCase());
		cm.setAcronym(comm.getAcronym().toUpperCase());
		cm.setInn(comm.isInn());
		communityService.saveCommunityMaster(cm);
		mv.setViewName("redirect:/GetCommunityMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@PostMapping("EditCommunity")
	public ModelAndView editCommunity(@Valid @ModelAttribute("community")AddCommunity comm,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null ) {
			mv.addObject("session", "destroy");
			mv.setViewName("redirect:/logout");
			return mv;
		}
		if(result.hasErrors()) {
			mv.addObject("editError", "error");
			mv.addObject("list", communityService.selectAll());
			mv.setViewName("CommunityMaster");
			return mv;
		}
		List<Community> list = communityService.selectAllExceptId(comm.getId());
		for(Community c : list) {
			if(c.getName().replaceAll("\\s", "").equalsIgnoreCase(comm.getName().replaceAll("\\s", ""))) {
				mv.addObject("editError", "error");
				mv.addObject("list", communityService.selectAll());
				mv.addObject("editExistCommunity","error");
				mv.setViewName("CommunityMaster");
				return mv;
			}else if(c.getAcronym().equalsIgnoreCase(comm.getAcronym())) {
				mv.addObject("editError", "error");
				mv.addObject("list", communityService.selectAll());
				mv.addObject("editExistAcronym","error");
				mv.setViewName("CommunityMaster");
				return mv;
			}
		}
		communityService.updateCommunity(comm);
		mv.setViewName("redirect:/GetCommunityMaster");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteCommunity")
	public ModelAndView deleteCommunity(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		mv.setViewName("redirect:/GetCommunityMaster");
		communityService.updateInnZero(id);
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetCountryMaster")
	public ModelAndView getCountryMaster(@RequestParam(value="added",required=false)String added,@RequestParam(value="updated",required=false)String updated,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;	
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.setViewName("CountryMaster");
		mv.addObject("country", new AddCountry());
		mv.addObject("list", countryService.selectAll());
		return mv;
	}
	
	@PostMapping("SaveCountryMaster")
	public ModelAndView saveCountryMaster(@Valid @ModelAttribute("country")AddCountry country,BindingResult result,HttpSession session,ModelMap model) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("CountryMaster");
			mv.addObject("list", countryService.selectAll());
			mv.addObject("addError", "error");
			return mv;
		}
		List<Country> exist = countryService.selectAll();
		for(Country c : exist) {
			if(country.getName().replaceAll("\\s", "").equalsIgnoreCase(c.getName().replaceAll("\\s", ""))) {
				mv.setViewName("CountryMaster");
				mv.addObject("list", countryService.selectAll());
				mv.addObject("addError","error");
				mv.addObject("addExistCountry", "exist");
				return mv;
			}else if(country.getAcronym().equalsIgnoreCase(c.getAcronym())) {
				mv.setViewName("CountryMaster");
				mv.addObject("list", countryService.selectAll());
				mv.addObject("addError","error");
				mv.addObject("addExistAcronym", "exist");
				return mv;
			}
		}
		countryService.saveCountryMaster(country.getName().toLowerCase(),country.getAcronym().toUpperCase(),country.isInn());
		mv.setViewName("redirect:/GetCountryMaster");
		mv.addObject("added", "success");
		return mv;
	}
	
	@PostMapping("EditCountry")
	public ModelAndView editCountry(@Valid @ModelAttribute("country")AddCountry country,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("CountryMaster");
			mv.addObject("list", countryService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Country> exist = countryService.selectAllExceptId(country.getId());
		for(Country c : exist) {
			if(c.getName().equalsIgnoreCase(country.getName())) {
				mv.setViewName("CountryMaster");
				mv.addObject("list", countryService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("edirExistCountry", "exist");
				return mv;
			}else if(c.getAcronym().equalsIgnoreCase(country.getAcronym())) {
				mv.setViewName("CountryMaster");
				mv.addObject("list", countryService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExistAcronym", "exist");
				return mv;
			}
		}
		countryService.updateCountry(country.getId(),country.getName(),country.getAcronym(),country.isInn()?1:0);
		mv.setViewName("redirect:/GetCountryMaster");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteCountry")
	public ModelAndView deleteCountry(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("CountryMaster");
			mv.addObject("session", "destroy");
			return mv;
		}
		countryService.updateInnZero(id);
		mv.setViewName("redirect:/GetCountryMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetDegreeMaster")
	public ModelAndView getDegreeMaster(@RequestParam(value="added",required=false)String added,@RequestParam(value="updated",required=false)String updated,@RequestParam(value="deleted",required=false)String deleted,HttpSession session,ModelMap model) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.addObject("degree", new AddDegree());
		mv.addObject("list", degreeService.selectAll());
		mv.setViewName("DegreeMaster");
		return mv;
	}
	
	@PostMapping("SaveDegreeMaster")
	public ModelAndView saveDegreeMaster(@Valid @ModelAttribute("degree")AddDegree degree,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("DegreeMaster");
			mv.addObject("list", degreeService.selectAll());
			mv.addObject("addError", "error");
			return mv;
		}
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		List<Degree> exist = degreeService.selectAll();
		for(Degree d : exist) {
			if(d.getName().replaceAll("\\s", "").equalsIgnoreCase(degree.getName().replaceAll("\\s", ""))) {
				mv.setViewName("DegreeMaster");
				mv.addObject("list", degreeService.selectAll());
				mv.addObject("addError", "error");
				mv.addObject("addExistDegree","exist");
				return mv;
			}else if(d.getAcronym().equalsIgnoreCase(degree.getAcronym().replaceAll("\\s", ""))) {
				mv.setViewName("DegreeMaster");
				mv.addObject("list", degreeService.selectAll());
				mv.addObject("addError", "error");
				mv.addObject("addExistAcronym","exist");
				return mv;
			}
		}
		degreeService.saveDegreeMaster(degree.getName().toLowerCase(),degree.getAcronym().toUpperCase().replaceAll("\\s", ""),degree.isInn());
		mv.addObject("added", "Success Message");
		mv.setViewName("redirect:/GetDegreeMaster");
		return mv;
	}
	
	@PostMapping("EditDegree")
	public ModelAndView editDegree(@Valid @ModelAttribute("degree") AddDegree degree, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("DegreeMaster");
			mv.addObject("editError", "error");
			mv.addObject("list", degreeService.selectAll());
			return mv;
		}
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		
		List<Degree> exist = degreeService.selectAllExceptId(degree.getId());
		for(Degree d : exist) {
			if(d.getName().replaceAll("\\s", "").equalsIgnoreCase(degree.getName().replaceAll("\\s", ""))) {
				mv.setViewName("DegreeMaster");
				mv.addObject("list", degreeService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExistDegree","exist");
				return mv;
			}else if(d.getAcronym().toUpperCase().equalsIgnoreCase(degree.getAcronym().replaceAll("\\s", ""))) {
				mv.setViewName("DegreeMaster");
				mv.addObject("list", degreeService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExistAcronym","exist");
				return mv;
			}
		}
		degreeService.updateDegree(degree.getId(),degree.getName().toLowerCase(),degree.getAcronym().toUpperCase().replaceAll("\\s", ""),degree.isInn()?1:0);
		mv.setViewName("redirect:/GetDegreeMaster");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteDegree")
	public ModelAndView deleteDegree(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("DegreeMaster");
			mv.addObject("session", "destroy");
			return mv;
		}
		degreeService.updateInnZero(id);
		mv.setViewName("redirect:/GetDegreeMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetDepartmentMaster")
	public ModelAndView getDepartmentMaster(@RequestParam(value="added",required=false)String added, @RequestParam(value="updated",required=false)String updated, @RequestParam(value="deleted",required=false)String deleted, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.setViewName("DepartmentMaster");
		mv.addObject("list", departmentService.selectAll());
		mv.addObject("department", new AddDepartment());
		return mv;
	}
	
	@PostMapping("SaveDepartment")
	public ModelAndView saveDepartmentMaster(@Valid @ModelAttribute("department")AddDepartment dept,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("DepartmentMaster");
			mv.addObject("list", departmentService.selectAll());
			mv.addObject("addError", "error");
			return mv;
		}
		List<Department> list = departmentService.selectAll();
		for(Department d : list) {
			if(d.getDegree().getId() == (int) dept.getDegree()) {
				if(d.getName().replaceAll("\\s", "").equalsIgnoreCase(dept.getName().replaceAll("\\s", ""))) {
					mv.setViewName("DepartmentMaster");
					mv.addObject("list", departmentService.selectAll());
					mv.addObject("addError", "error");
					mv.addObject("addExistDepartment","error");
					return mv;
				}else if(d.getAcronym().equalsIgnoreCase(dept.getAcronym().replaceAll("\\s", ""))) {
					mv.setViewName("DepartmentMaster");
					mv.addObject("list", departmentService.selectAll());
					mv.addObject("addError", "error");
					mv.addObject("addExistAcronym","error");
					return mv;
				}
			}
		}
		departmentService.saveDepartmentMaster(dept.getName().toLowerCase(),dept.getAcronym().toUpperCase().replaceAll("\\s", ""),dept.getDegree(),dept.isInn());
		mv.setViewName("redirect:/GetDepartmentMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@PostMapping("EditDepartment")
	public ModelAndView editDepartment(@Valid @ModelAttribute("department")AddDepartment dept, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:./logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("DepartmentMaster");
			mv.addObject("list", departmentService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Department> exist = departmentService.selectAllExceptId(dept.getId());
		for(Department d : exist) {
			if(d.getDegree().getId() == (int) dept.getDegree()) {
				if(d.getName().replaceAll("\\s", "").equalsIgnoreCase(dept.getName().replaceAll("\\s", ""))) {
					mv.setViewName("DepartmentMaster");
					mv.addObject("list", departmentService.selectAll());
					mv.addObject("editError", "error");
					mv.addObject("editExistDepartment","error");
					return mv;
				}else if(d.getAcronym().equalsIgnoreCase(dept.getAcronym().replaceAll("\\s", ""))) {
					mv.setViewName("DepartmentMaster");
					mv.addObject("list", departmentService.selectAll());
					mv.addObject("editError", "error");
					mv.addObject("editExistAcronym","error");
					return mv;
				}
			}
		}
		departmentService.update(dept.getId(),dept.getName(),dept.getAcronym(),dept.getDegree(),dept.isInn());
		mv.setViewName("redirect:/GetDepartmentMaster");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteDepartment")
	public ModelAndView deleteDepartment(@RequestParam("id")int id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:./logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		departmentService.updateInnZero(id,0);
		mv.setViewName("redirect:/GetDepartmentMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetDiplomaMaster")
	public String getDiplomaMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "DiplomaMaster";
	}
	
	@PostMapping("SaveDiplomaMaster")
	public ModelAndView saveDiplomaMaster(Diploma dm,HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		diplomaService.saveDiplomaMaster(dm);
			
		ModelAndView mv = new ModelAndView("DiplomaMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetDistrictMaster")
	public String getDistrictMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "DistrictMaster";
	}
	
	@PostMapping("SaveDistrictMaster")
	public ModelAndView saveDistrictMaster(District ds,HttpSession session) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		districtService.saveDistrictMaster(ds);
			
		ModelAndView mv = new ModelAndView("DistrictMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetStateMaster")
	public ModelAndView getStateMaster(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		mv.setViewName("StateMaster");
		return mv;
	}
	
	@PostMapping("SaveStateMaster")
	public ModelAndView saveStateMaster(State st,HttpSession session) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		stateService.saveStateMaster(st);
			
		ModelAndView mv = new ModelAndView("StateMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetGradeMaster")
	public String getGradeMaster(HttpSession session,ModelMap model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		return "GradeMaster";
	}
	
	@PostMapping("SaveGradeMaster")
	public ModelAndView saveGradeMaster(Grade gd,HttpSession session) {
		if(session.getAttribute("id") == null) {
			return new ModelAndView("redirect:/logout");
		}
		System.out.println(gd.toString());
		gradeService.saveGradeMaster(gd);
			
		ModelAndView mv = new ModelAndView("GradeMaster");
		mv.addObject("added", "Success Message");
		return mv;
	}
	
	@GetMapping("GetRegulationMaster")
	public ModelAndView getRegulationMaster(@RequestParam(value="added",required=false)String added,@RequestParam(value="updated",required=false)String updated,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;	
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.setViewName("RegulationMaster");
		mv.addObject("regulation", new AddRegulation());
		mv.addObject("list", regulationService.selectAll());
		return mv;
	}
	
	@PostMapping("SaveRegulationMaster")
	public ModelAndView saveRegulationMaster(@Valid @ModelAttribute("regulation")AddRegulation regulation,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("RegulationMaster");
			mv.addObject("list", regulationService.selectAll());
			mv.addObject("addError", "error");
			return mv;
		}
		List<Regulation> exist = regulationService.selectAll();
		for(Regulation r : exist) {
			if(r.getName().replaceAll("\\s", "").equalsIgnoreCase(regulation.getName().replaceAll("\\s", ""))) {
				mv.setViewName("RegulationMaster");
				mv.addObject("list", regulationService.selectAll());
				mv.addObject("addError","error");
				mv.addObject("addExistRegulation", "exist");
				return mv;
			}else if(r.getAcronym().equalsIgnoreCase(regulation.getAcronym())) {
				mv.setViewName("RegulationMaster");
				mv.addObject("list", regulationService.selectAll());
				mv.addObject("addError","error");
				mv.addObject("addExistAcronym", "exist");
				return mv;
			}
		}
		regulationService.saveRegulationMaster(regulation.getName().toLowerCase(),regulation.getAcronym().toUpperCase().replaceAll("\\s", ""),regulation.isInn());
		mv.setViewName("redirect:/GetRegulationMaster");
		mv.addObject("added", "success");
		return mv;
	}
	
	@PostMapping("EditRegulation")
	public ModelAndView editRegulation(@Valid @ModelAttribute("regulation")AddRegulation regulation,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("RegulationMaster");
			mv.addObject("list", regulationService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Regulation> exist = regulationService.selectAllExceptId(regulation.getId());
		for(Regulation r : exist) {
			if(r.getName().equalsIgnoreCase(regulation.getName())) {
				mv.setViewName("RegulationMaster");
				mv.addObject("list", regulationService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExistRegulation", "exist");
				return mv;
			}else if(r.getAcronym().equalsIgnoreCase(regulation.getAcronym())) {
				mv.setViewName("RegulationMaster");
				mv.addObject("list", regulationService.selectAll());
				mv.addObject("editError", "error");
				mv.addObject("editExistAcronym", "exist");
				return mv;
			}
		}
		regulationService.update(regulation.getId(),regulation.getName(),regulation.getAcronym(),regulation.isInn());
		mv.setViewName("redirect:/GetRegulationMaster");
		mv.addObject("updated", "success");
		return mv;
	}
	
	@PostMapping("DeleteRegulation")
	public ModelAndView deleteRegulation(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("RegulationMaster");
			mv.addObject("session", "destroy");
			return mv;
		}
		regulationService.updateInnZero(id,0);
		mv.setViewName("redirect:/GetRegulationMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
	
	@GetMapping("GetReligionMaster")
	public ModelAndView getReligionMaster(@RequestParam(value="added",required=false)String added,@RequestParam(value="updated",required=false)String updated,@RequestParam(value="deleted",required=false)String deleted,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;	
		}
		if(!(added == null))
			mv.addObject("added", "success");
		if(!(updated == null))
			mv.addObject("updated", "success");
		if(!(deleted == null))
			mv.addObject("deleted", "success");
		mv.setViewName("ReligionMaster");
		mv.addObject("religion", new AddReligion());
		mv.addObject("list", religionService.selectAll());
		return mv;
	}
	
	@PostMapping("SaveReligionMaster")
	public ModelAndView saveReligionMaster(@Valid @ModelAttribute("religion")AddReligion religion,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("ReligionMaster");
			mv.addObject("list", religionService.selectAll());
			mv.addObject("addError", "error");
			return mv;
		}
		List<Religion> exist = religionService.selectAll();
		for(Religion r : exist) {
			if(r.getName().replaceAll("\\s", "").equalsIgnoreCase(religion.getName().replaceAll("\\s", ""))) {
				mv.setViewName("ReligionMaster");
				mv.addObject("list", religionService.selectAll());
				mv.addObject("addError","error");
				mv.addObject("addExist", "exist");
				return mv;
			}
		}
		religionService.saveReligionMaster(religion.getName().toLowerCase(),religion.isInn());
		mv.setViewName("redirect:/GetReligionMaster");
		mv.addObject("added", "success");
		return mv;
	}

	@PostMapping("EditReligion")
	public ModelAndView editReligion(@Valid @ModelAttribute("religion")AddReligion religion,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		if(result.hasErrors()) {
			mv.setViewName("ReligionMaster");
			mv.addObject("list", religionService.selectAll());
			mv.addObject("editError", "error");
			return mv;
		}
		List<Religion> list = religionService.selectAllExceptId(religion.getId());
		for(Religion r : list) {
			if(r.getName().equalsIgnoreCase(religion.getName().replaceAll("\\s", ""))) {
				mv.setViewName("ReligionMaster");
				mv.addObject("list", religionService.selectAll());
				mv.addObject("editExist", "error");
				mv.addObject("editError", "error");
				return mv;			
			}
		}
		religionService.update(religion.getId(), religion.getName().toLowerCase(), religion.isInn());
		mv.setViewName("redirect:/GetReligionMaster");
		mv.addObject("updated", "Success Message");
		return mv;
	}
	
	@PostMapping("DeleteReligion")
	public ModelAndView deleteReligion(@RequestParam("id") int id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("id") == null) {
			mv.setViewName("redirect:/logout");
			mv.addObject("session", "destroy");
			return mv;
		}
		religionService.updateInnZero(id,0);
		mv.setViewName("redirect:/GetReligionMaster");
		mv.addObject("deleted", "success");
		return mv;
	}
}