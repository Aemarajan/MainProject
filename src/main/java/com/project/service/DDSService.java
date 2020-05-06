package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Batch;
import com.project.model.DDSMapping;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.Regulation;
import com.project.model.Section;
import com.project.model.Semester;
import com.project.model.Year;
import com.project.repository.DDSRepository;

@Service
public class DDSService {

	@Autowired
	DDSRepository ddsRepo;
	
	public List<DDSMapping> selectAll(){
		return ddsRepo.findAll();
	}

	public void save(Batch batch, Regulation regulation,Degree degree, Department department, Year year, Semester semester, Section section,int inn) {
		ddsRepo.save(new DDSMapping(batch,regulation,degree,department,year,semester,section,inn));
	}

	public DDSMapping selectById(int id) {
		List<DDSMapping> list = ddsRepo.findAll();
		for(DDSMapping d : list) {
			if(d.getId() == id)
				return d;
		}
		return null;
	}

	public void updateInn(int id, int inn) {
		ddsRepo.updateInnById(id,inn);
	}

	public DDSMapping selectByAllId(int degree, int department, int section) {
		List<DDSMapping> list = ddsRepo.findAll();
		for(DDSMapping d : list) {
			if(d.getDegree().getId() == degree && d.getDepartment().getId() == department && d.getSection().getId() == section)
				return d;
		}
		return null;
	}
	
}
