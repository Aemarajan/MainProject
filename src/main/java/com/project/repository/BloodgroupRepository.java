package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Bloodgroup;

public interface BloodgroupRepository extends JpaRepository<Bloodgroup, Integer>{

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM bloodgroup_master b where b.name=:name",nativeQuery=true)
	List<Bloodgroup> selectByName(@Param("name")String name);

}
