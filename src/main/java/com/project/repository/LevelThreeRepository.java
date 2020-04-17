package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.LevelThree;

public interface LevelThreeRepository extends JpaRepository<LevelThree, Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM lvl3 l where l.lvl3_id !=:lvl3_id",nativeQuery=true)
	List<LevelThree> findAllById(@Param("lvl3_id")int lvl3_id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE lvl3 l SET l.name=:name, l.inn=:inn WHERE l.lvl3_id=:lvl3_id",nativeQuery=true)
	void update(@Param("lvl3_id")int lvl3_id,@Param("name") String name,@Param("inn") int i);
}
