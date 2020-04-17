package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.customvalidator.Address;
import com.project.customvalidator.Personal;
import com.project.model.Bloodgroup;
import com.project.model.CSDMapping;
import com.project.model.Community;
import com.project.model.Country;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.District;
import com.project.model.LevelOne;
import com.project.model.LevelThree;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.Regulation;
import com.project.model.Religion;
import com.project.model.State;
import com.project.model.User;
import com.project.model.Year;
import com.project.service.BloodgroupService;
import com.project.service.CSDService;
import com.project.service.CommunityService;
import com.project.service.CountryService;
import com.project.service.DegreeService;
import com.project.service.DepartmentService;
import com.project.service.DistrictService;
import com.project.service.LanguageService;
import com.project.service.LevelOneService;
import com.project.service.LevelThreeService;
import com.project.service.LevelTwoService;
import com.project.service.MenuService;
import com.project.service.PrivilegeService;
import com.project.service.ProfileService;
import com.project.service.RegulationService;
import com.project.service.ReligionService;
import com.project.service.StateService;
import com.project.service.UserService;
import com.project.service.YearService;

@RestController
@RequestMapping("api")
public class ApiController {

	@Autowired
	LevelTwoService lvl2s;

	@Autowired
	LevelOneService lvl1s;

	@Autowired
	LevelThreeService lvl3s;

	@Autowired
	PrivilegeService privilegeService;

	@Autowired
	MenuService menuService;

	@Autowired
	UserService userService;

	@Autowired
	DegreeService degreeService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	CommunityService communityService;
	
	@Autowired
	StateService stateService;

	@Autowired
	CountryService countryService;

	@Autowired
	RegulationService regulationService;

	@Autowired
	ReligionService religionService;
	
	@Autowired
	DistrictService districtService;

	@Autowired
	YearService yearService;
	
	@Autowired
	LanguageService languageService;
	
	@Autowired
	BloodgroupService bloodService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	CSDService csdService;
	
	@GetMapping("/getAllLevelOneByDd")
	public List<LevelOne> getAllLevelOneByDd(){
		return lvl1s.selectByDd(1);
	}
	
	@GetMapping("/getAllLevelOne")
	public List<LevelOne> getAllLevelOne(){
		return lvl1s.selectAll();
	}
	
	@GetMapping("/getAllLevelThree")
	public List<LevelThree> getAllLevelThree(){
		return lvl3s.selectAll();
	}
	
	@GetMapping("/getLvl2/{id}")
	public List<LevelTwo> getLevelTwoById(@PathVariable("id") int id){
		List<LevelTwo> list = lvl2s.selectById(id);
		return list;
	}
	
	@GetMapping("/getLevelThree/{lvl1}/{lvl2}")
	public List<Menu> getLevelThree(@PathVariable("lvl1") int lvl1,@PathVariable("lvl2") int lvl2){
		List<Menu> list = menuService.selectByLevelOneAndLevelTwoId(lvl1, lvl2);
		return list;
	}
	
	@GetMapping("/getLvl2DD/{id}")
	public List<LevelTwo> getLevelTwoByDd(@PathVariable("id") int id){
		List<LevelTwo> list = lvl2s.selectByLevelOneAndDD(id, 1);
		return list;
	}
	
	@GetMapping("/getUserPp1")
	public List<User> getUser(){
		List<User> list = userService.selectByPp(1);
		return list;
	}
	
	@GetMapping("/getUserPp0")
	public List<User> getUserPpZero(){
		List<User> list = userService.selectByPp(0);
		return list;
	}
	
	@GetMapping("/getAllDegree")
	public List<Degree> getAllDegree(){
		return degreeService.selectAll();
	}
	
	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment(){
		return departmentService.selectAll();
	}
	
	@GetMapping("/getAllState")
	public List<State> getAllState(){
		return stateService.selectAll();
	}
	
	@GetMapping("/getAllCountry")
	public List<Country> getAllCountry(){
		return countryService.selectAll();
	}
	
	@GetMapping("/getAllRegulation")
	public List<Regulation> getAllRegulation(){
		return regulationService.selectAll();
	}
	
	@GetMapping("getAllDistrict")
	public List<District> getAllDistrict(){
		return districtService.selectAll();
	}
	
	@GetMapping("getYearByDegreeId/{id}")
	public List<Year> getYearByDegreeId(@PathVariable("id")int id){
		return yearService.selectByDegreeId(id);
	}
	
	@GetMapping("getAllDepartmentByDegreeId/{id}")
	public List<Department> getAllDepartmentByDegree(@PathVariable("id")int id){
		return departmentService.selectDepartmentByDegree(id);
	}
	
	@GetMapping("getAllYear")
	public List<Year> getAllYear(){
		return yearService.selectAll();
	}
	
	@GetMapping("getAllBlood")
	public List<Bloodgroup> getAllBlood(){
		return bloodService.selectAll();
	}
	
	@GetMapping("getAllReligion")
	public List<Religion> getAllReligion(){
		return religionService.selectAll();
	}
	
	@GetMapping("getAllCommunity")
	public List<Community> getAllCommunity(){
		return communityService.selectAll();
	}
	
	@GetMapping("getAllCSD")
	public List<CSDMapping> getAllCSD(){
		return csdService.selectAll();
	}
	
	@PostMapping(value="savePersonalJson",produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Personal savePersonal(@RequestBody Personal personal) {
		profileService.updatePersonal(personal.getDob(),personal.getBlood(),personal.getReligion(),personal.getCommunity(),personal.getId());
		return personal;
	}
	
	@GetMapping("getAllStateByCountryId/{id}")
	public List<CSDMapping> getAllStateByCountry(@PathVariable("id")int id){
		return csdService.selectAllStateByCountryId(id);
	}
	
	@GetMapping("getAllDistrictByStateId/{countryId}/{stateId}")
	public List<CSDMapping> getAllDistrictByState(@PathVariable("stateId")int stateid,@PathVariable("countryId")int countryid){
		return csdService.selectAllDistrictByStateId(countryid,stateid);
	}
	
	@PostMapping(value="saveAddressJson",produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Address saveAddress(@RequestBody Address address) {
		profileService.updateAddress(address.getId(), address.getDoor_no(), address.getLine1(), address.getLine2(), address.getLine3(), 
				csdService.selectByCSDId(address.getCountry(),address.getState(),address.getDistrict()),address.getPincode(), address.isPermanent()?1:0, address.getP_door_no(), 
				address.getP_line1(), address.getP_line2(), address.getP_line3(), csdService.selectByCSDId(address.getP_country(),address.getP_state(),address.getP_district()),address.getP_pincode());
		return address;
	}
	
}