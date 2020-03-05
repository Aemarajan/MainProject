package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Year;

public interface YearRepository extends JpaRepository<Year,Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE year_master y SET y.inn=:inn WHERE y.id=:id",nativeQuery=true)
	void update(@Param("id")int id, @Param("inn")int i);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM year_master y WHERE y.degree=:id",nativeQuery=true)
	List<Year> findByDegreeId(@Param("id")int id);

}
