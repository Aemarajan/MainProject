package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Country;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.District;
import com.project.model.LevelOne;
import com.project.model.LevelThree;
import com.project.model.LevelTwo;
import com.project.model.Menu;
import com.project.model.Regulation;
import com.project.model.State;
import com.project.model.User;
import com.project.model.Year;
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
import com.project.service.RegulationService;
import com.project.service.StateService;
import com.project.service.UserService;
import com.project.service.YearService;
import com.project.validator.Personal;

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
	StateService stateService;

	@Autowired
	CountryService countryService;

	@Autowired
	RegulationService regulationService;

	@Autowired
	DistrictService districtService;

	@Autowired
	YearService yearService;
	
	@Autowired
	LanguageService languageService;
	
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
	
	@RequestMapping(value="savePersonalJson",method=RequestMethod.POST)
	public ResponseEntity<Object> savePersonal(@RequestBody Personal personal) {
		System.out.println(personal.getUsername());
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
}