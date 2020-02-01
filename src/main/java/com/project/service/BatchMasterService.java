package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.BatchMaster;
import com.project.repository.BatchMasterRepository;

@Service
public class BatchMasterService {

	@Autowired
	BatchMasterRepository bmrepo;
	
	public void saveBatchMaster(BatchMaster bm) {
		bmrepo.save(bm);
	}
	
	public List<BatchMaster> selectAll(){
		List<BatchMaster> list = bmrepo.findAll();
		return list;
	}

	public List<BatchMaster> selectBatchByFromTo(int from_year, int to_year) {
		List<BatchMaster> list = bmrepo.selectByFromTo(from_year,to_year); 
		return list;
	}
}
