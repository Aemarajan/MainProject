package com.project.repository;

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

}
