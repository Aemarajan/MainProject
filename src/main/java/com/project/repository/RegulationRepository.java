package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Regulation;

public interface RegulationRepository extends JpaRepository<Regulation, Integer>{

	@Transactional
	@Modifying
	@Query(value="UPDATE regulation_master r SET r.name=:name, r.acronym=:acronym,r.inn=:inn WHERE r.id=:id",nativeQuery=true)
	void update(@Param("id")int id, @Param("name")String name, @Param("acronym")String acronym, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM regulation_master r WHERE r.id!=:id ",nativeQuery=true)
	List<Regulation> findAllExceptId(@Param("id")int id);

	@Transactional
	@Modifying
	@Query(value="UPDATE regulation_master r SET r.inn=:i WHERE r.id=:id",nativeQuery=true)
	void updateInnZero(@Param("id")int id, @Param("i")int i);
}
