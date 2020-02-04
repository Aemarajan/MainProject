package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Regulation;

public interface RegulationRepository extends JpaRepository<Regulation, Integer>{

}
