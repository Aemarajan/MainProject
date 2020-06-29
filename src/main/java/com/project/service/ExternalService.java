package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.External;
import com.project.model.Grade;
import com.project.model.Semester;
import com.project.model.User;
import com.project.repository.ExternalRepository;

@Service
public class ExternalService {

	@Autowired
	ExternalRepository extRepo;
	
	public List<External> selectAll(){
		List<External> list = extRepo.findAll();
		return list;
	}
	
	public List<External> selectAllExceptId(int id) {
		return extRepo.findAllExceptId(id);
	}
	
	public void saveExternalMarks(
			User user, Semester semester, Grade ma5161, Grade mc5101, Grade mc5102, Grade mc5103,
			Grade mc5104, Grade mc5111, Grade mc5112, Grade mc5113, Grade mc5201, Grade mc5202, Grade mc5203,
			Grade mc5204, Grade mc5205, Grade mc5211, Grade mc5212, Grade mc5213, Grade mc5301, Grade mc5302,
			Grade mc5303, Grade mc5304, Grade mc5305, Grade mc5311, Grade mc5312, Grade mc5313, Grade mc5401,
			Grade mc5402, Grade mc5403, Grade mc5404, Grade mc5001, Grade mc5002, Grade mc5003, Grade mc5004,
			Grade mc5005, Grade mc5411, Grade mc5412, Grade mc5413, Grade mc5501, Grade mc5502, Grade mc5503,
			Grade mc5006, Grade mc5007, Grade mc5008, Grade mc5009, Grade mc5010, Grade mc5011, Grade mc5012,
			Grade mc5013, Grade mc5014, Grade mc5015, Grade mc5511, Grade mc5512, Grade mc5513, Grade mc5611, 
			double gpa, double cgpa, int inn ){
		
		External ex = new External(
				user, semester, ma5161, mc5101, mc5102, mc5103, mc5104,
				 mc5111, mc5112, mc5113, mc5201, mc5202, mc5203, mc5204,
				 mc5205, mc5211, mc5212, mc5213, mc5301, mc5302, mc5303,
				 mc5304, mc5305, mc5311, mc5312, mc5313, mc5401, mc5402,
				 mc5403, mc5404, mc5001, mc5002, mc5003, mc5004, mc5005,
				 mc5411, mc5412, mc5413, mc5501, mc5502, mc5503, mc5006,
				 mc5007, mc5008, mc5009, mc5010, mc5011, mc5012, mc5013,
				 mc5014, mc5015, mc5511, mc5512, mc5513, mc5611, gpa, cgpa, inn);
		extRepo.save(ex);
	}

	public List<External> SelectSemesterMarks(int i,int user) {
		return extRepo.findSemesterMarks(i,user);
	}

	public List<External> getMarksByStudentAndSemester(int student, int sem) {
		return extRepo.findMarksByStudentAndSemester(student,sem);
	}
}
