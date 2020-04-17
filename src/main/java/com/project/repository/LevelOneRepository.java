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

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl1 l where l.lvl1_id !=:lvl1_id",nativeQuery=true)
	List<LevelOne> findAllById(@Param("lvl1_id")int lvl1_id);

	@Transactional
	@Modifying
	@Query(value="UPDATE lvl1 l SET l.name=:name, l.dd=:dd, l.inn=:inn WHERE l.lvl1_id=:lvl1id",nativeQuery=true)
	void update(@Param("lvl1id")int lvl1_id,@Param("name") String name,@Param("dd") int dd,@Param("inn") int i);
	
}
