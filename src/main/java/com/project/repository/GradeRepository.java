package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

}
