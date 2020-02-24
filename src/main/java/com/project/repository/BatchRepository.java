package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer>{

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM batch_master b where b.from_year=:from AND b.to_year=:to",nativeQuery=true)
	List<Batch> selectByFromTo(@Param("from")int from_year,@Param("to") int to_year);

	@Transactional
	@Modifying
	@Query(value="UPDATE batch_master SET from_year=:f,to_year=:t,no_of_years=:n,inn=:inn WHERE id=:id",nativeQuery=true)
	void updateBatch(@Param("id")int id,@Param("f") int f_year,@Param("t") int t_year,@Param("n") int n_year,@Param("inn") int inn);

	@Transactional
	@Modifying
	@Query(value="UPDATE batch_master SET inn=:inn WHERE id=:id",nativeQuery=true)
	void updateBatch(@Param("id")int id,@Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM batch_master WHERE id!=:id",nativeQuery=true)
	List<Batch> findAllExceptId(int id);
	
}
