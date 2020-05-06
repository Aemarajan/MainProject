package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.SSMapping;
import com.project.repository.SSMappingRepository;

@Service
public class SSMappingService {

	@Autowired
	SSMappingRepository ssRepo;
	
	public List<SSMapping> selectAll() {
		return ssRepo.findAll();
	}

	public void save(SSMapping ss) {		
		ssRepo.save(ss);
	}

	public SSMapping selectById(int id) {
		List<SSMapping> list = ssRepo.findAll();
		for(SSMapping s:list) {
			if(s.getId() == id)
				return s;
		}
		return null;
	}

	public void updateInn(int id, int i) {
		ssRepo.updateInn(id,i);
	}

	public SSMapping selectBySSMappingId(int p_staff, int p_student) {
		List<SSMapping> list = ssRepo.findAll();
		for(SSMapping s : list) {
			if(s.getStaff().getUser_id() == p_staff && s.getStudent().getUser_id() == p_student)
				return s;
		}
		return null;
	}

	public List<SSMapping> selectAllStudentByStaffId(int id) {
		List<SSMapping> list = ssRepo.findAll();
		List<SSMapping> fin = new ArrayList<SSMapping>();
		for(SSMapping s : list) {
			if(s.getStaff().getUser_id() == id) {
				fin.add(s);
			}
		}
		return fin;
	}
}
