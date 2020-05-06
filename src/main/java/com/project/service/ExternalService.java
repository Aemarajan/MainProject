package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.External;
import com.project.model.User;
import com.project.repository.ExternalRepository;

@Service
public class ExternalService {

	@Autowired
	ExternalRepository extRepo;
	
	public void saveExternalMarks(User user_id, String ma5161, String mc5101, String mc5102, String mc5103, String mc5104,
			String mc5111, String mc5112, String mc5113, String mc5201, String mc5202, String mc5203, String mc5204,
			String mc5205, String mc5211, String mc5212, String mc5213, String mc5301, String mc5302, String mc5303,
			String mc5304, String mc5305, String mc5311, String mc5312, String mc5313, String mc5401, String mc5402,
			String mc5403, String mc5404, String mc5001, String mc5002, String mc5003, String mc5004, String mc5005,
			String mc5411, String mc5412, String mc5413, String mc5501, String mc5502, String mc5503, String mc5006,
			String mc5007, String mc5008, String mc5009, String mc5010, String mc5011, String mc5012, String mc5013,
			String mc5014, String mc5015, String mc5511, String mc5512, String mc5513, String mc5611, int inn) {
		
		External ex = new External(
				user_id, ma5161, mc5101, mc5102, mc5103, mc5104,
				 mc5111, mc5112, mc5113, mc5201, mc5202, mc5203, mc5204,
				 mc5205, mc5211, mc5212, mc5213, mc5301, mc5302, mc5303,
				 mc5304, mc5305, mc5311, mc5312, mc5313, mc5401, mc5402,
				 mc5403, mc5404, mc5001, mc5002, mc5003, mc5004, mc5005,
				 mc5411, mc5412, mc5413, mc5501, mc5502, mc5503, mc5006,
				 mc5007, mc5008, mc5009, mc5010, mc5011, mc5012, mc5013,
				 mc5014, mc5015, mc5511, mc5512, mc5513, mc5611, inn);
		extRepo.save(ex);
	}
}
