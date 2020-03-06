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
	
	@Transactional
	@Modifying
	@Query(value="UPDATE syllabus_master s SET s.subject_name=:subject_name,s.subject_code=:subject_code,s.credit=:credit,s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void update(@Param("id") int id,@Param("subject_name")String name,@Param("subject_code") String code,@Param("credit") int credit, @Param("inn") int i);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE syllabus_master s SET s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void updateInn(@Param("id")int id, @Param("inn")int i);
}
