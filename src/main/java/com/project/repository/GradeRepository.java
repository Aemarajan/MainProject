package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Grade;
import com.project.model.Regulation;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM grade_master g WHERE g.id!=:id ",nativeQuery=true)
	List<Grade> findAllExceptId(@Param("id")int id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE grade_master g SET g.word=:word, g.acronym=:acronym, g.point=:point, g.marks_range=:marks_range, g.regulation=:regulation, g.inn=:inn WHERE g.id=:id",nativeQuery=true)
	void update(@Param("id")int id, @Param("word")String word, @Param("acronym")String acronym, @Param("point")int point, @Param("marks_range")String marks_range, @Param("regulation")Regulation regulation, @Param("inn")int inn);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE grade_master g SET g.inn=:i WHERE g.id=:id",nativeQuery=true)
	void updateInnZero(@Param("id")int id, @Param("i")int i);
}
