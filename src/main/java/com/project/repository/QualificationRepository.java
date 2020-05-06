package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification,Integer> {

}
