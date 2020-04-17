package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Experience;
import com.project.model.User;
import com.project.repository.ExperienceRepository;

@Service
public class ExperienceService {

	@Autowired
	ExperienceRepository expRepo;
	
	public List<Experience> selectAllByUserId(Object object){
		List<Experience> list = expRepo.findAllByUserId(object);
		return list;
	}

	public void saveExperience(User user_id,String institute_name, String designation, String from_date, String to_date, int diff_years,int diff_months,int diff_days, int i) {
		Experience experience = new Experience(user_id,institute_name,designation,from_date,to_date,diff_years,diff_months,diff_days,i);
		expRepo.save(experience);
	}

	public void updateInnZero(int id, int i) {
		expRepo.updateInn(id,i);
	}

	public void updateExperience(int id,String institute_name, String designation, String from_date, String to_date, int diff_years,int diff_months,int diff_days, int i) {
		expRepo.updateExperience(institute_name,designation,from_date,to_date,diff_years,diff_months,diff_days,i,id);
	}	
	
	public List<Experience> selectAllExceptId(int id){
		return expRepo.findAllExceptId(id);
	}
}