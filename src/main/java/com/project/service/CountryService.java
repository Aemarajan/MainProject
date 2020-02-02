package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Country;
import com.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository cnrepo;
	
	public void saveCountryMaster(Country cn) {
		cnrepo.save(cn);
	}
	
	public List<Country> selectAll(){
		List<Country> list = cnrepo.findAll();
		return list;
	}
	
}
