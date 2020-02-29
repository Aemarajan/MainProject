package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Year;
import com.project.repository.YearRepository;

@Service
public class YearService {

	@Autowired
	YearRepository yearRepo;
	
	public List<Year> selectAll(){
		return yearRepo.findAll();
	}
	
	
	public Year selectById(int id) {
		List<Year> list = yearRepo.findAll();
		for(Year y : list) {
			if(y.getId() == id)
				return y;
		}
		return null;
	}

}
