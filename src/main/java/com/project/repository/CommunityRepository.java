package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Community;

public interface CommunityRepository extends JpaRepository<Community, Integer>{

	List<Community> findByAcronym(String acronym);
	
	List<Community> findByName(String name); 

}
