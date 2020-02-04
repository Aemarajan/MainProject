package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.State;
import com.project.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository strepo;

	public void saveStateMaster(State st) {
		strepo.save(st);
	}
	
	public List<State> selectAll(){
		List<State> list = strepo.findAll();
		return list;
	}
}
