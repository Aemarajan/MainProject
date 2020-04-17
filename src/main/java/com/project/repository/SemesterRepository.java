package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer>{

	@Transactional
	@Modifying
	@Query(value="UPDATE semester_master s SET s.name=:name,s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void update(@Param("id")int id, @Param("name")String name, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM semester_master s WHERE s.id!=:id ",nativeQuery=true)
	List<Semester> findAllExceptId(@Param("id")int id);

	@Transactional
	@Modifying
	@Query(value="UPDATE semester_master s SET s.inn=:i WHERE s.id=:id",nativeQuery=true)
	void updateInnZero(@Param("id")int id, @Param("i")int i);
}
