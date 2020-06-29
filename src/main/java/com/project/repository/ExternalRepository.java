package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.External;


public interface ExternalRepository extends JpaRepository<External, Integer>{

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM external e WHERE e.id!=:id ",nativeQuery=true)
	List<External> findAllExceptId(@Param("id")int id);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM external e WHERE e.semester=:i AND e.user=:user",nativeQuery=true)
	List<External> findSemesterMarks(@Param("i")int i,@Param("user") int user);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM external e WHERE e.semester=:sem AND e.user=:student",nativeQuery=true)
	List<External> findMarksByStudentAndSemester(@Param("student") int student,@Param("sem") int sem);
}
