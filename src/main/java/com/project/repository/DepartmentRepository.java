package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Degree;
import com.project.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Transactional
	@Modifying
	@Query(value="UPDATE department_master d SET d.name=:name, d.acronym=:acronym,d.degree=:degree,d.inn=:inn WHERE d.id=:id",nativeQuery=true)
	void update(@Param("id")int id, @Param("name")String name, @Param("acronym")String acronym, @Param("degree")Degree degree, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM department_master d WHERE id!=:id ",nativeQuery=true)
	List<Department> findAllExceptId(@Param("id")int id);

	@Transactional
	@Modifying
	@Query(value="UPDATE department_master d SET d.inn=:i WHERE d.id=:id",nativeQuery=true)
	void updateInnZero(@Param("id")int id, @Param("i")int i);

}
