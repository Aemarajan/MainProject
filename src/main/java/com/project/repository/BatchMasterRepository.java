package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.BatchMaster;

public interface BatchMasterRepository extends JpaRepository<BatchMaster, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM batch_master b where b.from_year=:from AND b.to_year=:to",nativeQuery=true)
	List<BatchMaster> selectByFromTo(@Param("from")int from_year,@Param("to") int to_year);

}
