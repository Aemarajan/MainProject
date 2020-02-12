package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Batch;
import com.project.repository.BatchRepository;

@Service
public class BatchService {

	@Autowired
	BatchRepository bmrepo;
	
	public void saveBatchMaster(Batch bm) {
		bmrepo.save(bm);
	}
	
	public List<Batch> selectAll(){
		List<Batch> list = bmrepo.findAll();
		return list;
	}

	public Batch selectBatchByFromTo(int from_year, int to_year) {
		List<Batch> list = bmrepo.selectByFromTo(from_year,to_year);
		Batch batch = new Batch();
		for(Batch b:list) {
			if(b.getFrom_year() == from_year && b.getTo_year() == to_year) {
				batch.setFrom_year(b.getFrom_year());
				batch.setTo_year(b.getTo_year());
				batch.setTo_year(b.getNo_of_years());
				if(b.getInn() == 1)
					batch.setInn(true);
				else
					batch.setInn(false);
				return batch;
			}
		}
		return null;
	}
	
	public Batch selectBatchByFromTo(int from_year, int to_year,int inn) {
		List<Batch> list = bmrepo.selectByFromTo(from_year,to_year);
		Batch batch = new Batch();
		for(Batch b:list) {
			if(b.getFrom_year() == from_year && b.getTo_year() == to_year && b.getInn() == inn) {
				batch.setFrom_year(b.getFrom_year());
				batch.setTo_year(b.getTo_year());
				batch.setTo_year(b.getNo_of_years());
				if(b.getInn() == 1)
					batch.setInn(true);
				else
					batch.setInn(false);
				return batch;
			}
		}
		return null;
	}

	public void updateBatchMaster(int id, int f_year, int t_year, int n_year, int inn) {
		bmrepo.updateBatch(id,f_year,t_year,n_year,inn);
	}

	public void deleteById(int id) {
		bmrepo.deleteById(id);		
	}
}
