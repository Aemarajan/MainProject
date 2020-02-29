package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Year;

public interface YearRepository extends JpaRepository<Year,Integer> {

}
