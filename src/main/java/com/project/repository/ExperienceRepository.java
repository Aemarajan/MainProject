package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM experience e WHERE e.user_id=:id",nativeQuery = true)
	List<Experience> findAllByUserId(@Param("id") Object object);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE experience e SET e.institute_name=:institute_name,e.designation=:designation,e.from_date=:from_date,e.to_date=:to_date,e.diff_years=:diff_years,e.diff_months=:diff_months,e.diff_days=:diff_days,e.inn=:inn WHERE e.id=:id", nativeQuery = true)
	void updateExperience(@Param("institute_name") String institute_name,@Param("designation") String designation,@Param("from_date") String from_date,@Param("to_date") String to_date,@Param("diff_years") int diff_years,@Param("diff_months") int diff_months,@Param("diff_days") int diff_days,@Param("inn") int i,@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE experience e SET e.inn=:inn WHERE e.id=:id", nativeQuery = true)
	void updateInn(@Param("id") int id, @Param("inn") int i);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM experience e WHERE e.id!=:id", nativeQuery = true)
	List<Experience> findAllExceptId(@Param("id") int id);
}
