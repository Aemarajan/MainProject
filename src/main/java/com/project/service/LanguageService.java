package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Language;
import com.project.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository lgrepo;

	public void saveLanguageMaster(Language lg) {
		lgrepo.save(lg);
	}
	
	public List<Language> selectAll(){
		List<Language> list = lgrepo.findAll();
		return list;
	}
	
}
