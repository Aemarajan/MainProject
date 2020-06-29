package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.AcademicMapping;
import com.project.model.Batch;
import com.project.model.Degree;
import com.project.model.Department;
import com.project.model.Regulation;
import com.project.model.Section;
import com.project.model.Semester;
import com.project.model.User;
import com.project.model.Year;
import com.project.repository.AcademicMappingRepository;

@Service
public class AcademicMappingService {

	@Autowired
	AcademicMappingRepository acaRepo;
	
	public List<AcademicMapping> selectAll(){
		return acaRepo.findAll();
	}

	public void save(User user,Batch batch, Regulation regulation,Degree degree, Department department, Year year, Semester semester, Section section,int status,int inn) {
		acaRepo.save(new AcademicMapping(user,batch,regulation,degree,department,year,semester,section,status,inn));
	}

	public AcademicMapping selectById(int id) {
		List<AcademicMapping> list = acaRepo.findAll();
		for(AcademicMapping d : list) {
			if(d.getId() == id)
				return d;
		}
		return null;
	}

	public void updateInn(int id, int inn) {
		acaRepo.updateInnById(id,inn);
	}

	public AcademicMapping selectByAllId(int degree, int department, int section) {
		List<AcademicMapping> list = acaRepo.findAll();
		for(AcademicMapping d : list) {
			if(d.getDegree().getId() == degree && d.getDepartment().getId() == department && d.getSection().getId() == section)
				return d;
		}
		return null;
	}

	public List<AcademicMapping> selectAllStudentsByBRYSS(int b, int r, int y, int sem, int sec) {
		return acaRepo.findAllStudentsByBRYSS(b,r,y,sem,sec);
	}
}
