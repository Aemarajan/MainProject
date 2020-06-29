package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.RSSMapping;
import com.project.repository.RSSMappingRepository;

@Service
public class RSSMappingService {

	@Autowired
	RSSMappingRepository rssRepo;
	
	public List<RSSMapping> selectAll() {
		return rssRepo.findAll();
	}

	public void save(RSSMapping rss) {		
		rssRepo.save(rss);
	}

	public RSSMapping selectById(int id) {
		List<RSSMapping> list = rssRepo.findAll();
		for(RSSMapping rss:list) {
			if(rss.getId() == id)
				return rss;
		}
		return null;
	}

	public void updateInn(int id, int i) {
		rssRepo.updateInn(id,i);
	}
	public List<RSSMapping> checkRSSCombo(int regulation, int semester, int subject) {
		return rssRepo.findRSSCombo(regulation,semester,subject);
	}
}
