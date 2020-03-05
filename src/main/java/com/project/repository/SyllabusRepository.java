package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Syllabus;

public interface SyllabusRepository extends JpaRepository<Syllabus,Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM syllabus_master s WHERE s.id!=:id",nativeQuery=true)
	List<Syllabus> findAllExceptId(@Param("id")int id);	
	
}
