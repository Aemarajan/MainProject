package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.LevelOne;

public interface LevelOneRepository extends JpaRepository<LevelOne, Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl1 l where l.dd =:dd",nativeQuery=true)
	List<LevelOne> selectByDdOne(@Param("dd")int dd);
	
}
