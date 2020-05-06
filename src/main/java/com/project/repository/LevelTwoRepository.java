package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.model.LevelTwo;

public interface LevelTwoRepository extends JpaRepository<LevelTwo, Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl2 l where l.dd =:dd",nativeQuery=true)
	List<LevelTwo> selectByDdOne(@Param("dd")int dd);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl2 l where l.lvl1_id =:lvl1_id",nativeQuery=true)
	List<LevelTwo> selectByLvl1id(@Param("lvl1_id")int lvl1_id);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl2 l where l.lvl1_id =:lvl1 AND l.dd =:dd",nativeQuery=true)
	List<LevelTwo> selectByLevelOneAndDd(@Param("lvl1")int id,@Param("dd") int i);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl2 l where l.lvl2_id !=:lvl2_id",nativeQuery=true)
	List<LevelTwo> findAllById(@Param("lvl2_id")int lvl2_id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE lvl2 l SET l.name=:name, l.dd=:dd, l.inn=:inn WHERE l.lvl2_id=:lvl2_id",nativeQuery=true)
	void update(@Param("lvl2_id")int lvl2_id,@Param("name") String name,@Param("dd") int dd,@Param("inn") int i);
}
