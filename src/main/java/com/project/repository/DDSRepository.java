package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.DDSMapping;

public interface DDSRepository extends JpaRepository<DDSMapping, Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE dds d SET d.inn=:inn WHERE d.id=:id",nativeQuery=true)
	void updateInnById(@Param("id")int id, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM dds d WHERE d.year=:year AND d.section=:section",nativeQuery=true)
	List<DDSMapping> findAllStudentsByYearAndSection(@Param("year") int year, @Param("section") int section);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM dds d WHERE d.batch=:batch AND d.regulation=:regulation AND d.degree=:degree AND d.department=:department AND d.year=:year AND d.semester=:semester AND d.section=:section",nativeQuery=true)
	List<DDSMapping> findDDSCombo(@Param("batch") int batch,@Param("regulation") int regulation,@Param("degree") int degree,@Param("department") int department,@Param("year") int year,@Param("semester") int semester,@Param("section") int section);
}