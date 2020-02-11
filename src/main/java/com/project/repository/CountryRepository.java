package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

	List<Country> findByAcronym(String acronym);
	
	List<Country> findByName(String country);

}
