package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.AcademicMapping;

public interface AcademicMappingRepository extends JpaRepository<AcademicMapping, Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE academic a SET a.inn=:inn WHERE a.id=:id",nativeQuery=true)
	void updateInnById(@Param("id")int id, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM academic a WHERE a.batch=:batch AND a.regulation=:regulation AND a.year=:year AND a.semester=:semester AND a.section=:section",nativeQuery=true)
	List<AcademicMapping> findAllStudentsByBRYSS(@Param("batch") int b,@Param("regulation") int r,@Param("year") int y,@Param("semester") int sem,@Param("section") int sec);

}
