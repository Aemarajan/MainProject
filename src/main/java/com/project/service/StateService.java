package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Country;
import com.project.model.State;
import com.project.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository strepo;

	@Autowired
	CountryService countryService;
	
	public void saveStateMaster(State st) {
		strepo.save(st);
	}
	
	public List<State> selectAll(){
		List<State> list = strepo.findAll();
		return list;
	}

	public void saveState(String name, String acronym, Country country, boolean i) {
		State state = new State(name,acronym,country,i?1:0);
		strepo.save(state);
	}

	public void update(String name, String acronym, Integer country, boolean inn,int id) {
		strepo.update(name,acronym,countryService.selectById(country),inn?1:0,id);
	}

	public List<State> selectAllExceptId(int id) {
		return strepo.findAllExceptId(id);
	}

	public void updateInnZero(int id, int i) {
		strepo.updateInn(id,i);
	}
}
