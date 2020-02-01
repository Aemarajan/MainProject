package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM menu m where m.lvl1_id=:lvl1 AND m.lvl2_id=:lvl2",nativeQuery = true)
	public List<Menu> selectByOneAndTwoId(@Param("lvl1") int lvl1,@Param("lvl2") int lvl2);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM menu where lvl1_id=:lvl1 AND lvl2_id=:lvl2 AND lvl3_id=:lvl3",nativeQuery=true)
	public void deleteByLevel(@Param("lvl1")int lvl1_id,@Param("lvl2") int lvl2_id,@Param("lvl3") int lvl3_id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM menu m where m.lvl1_id=:lvl1 AND m.lvl2_id=:lvl2 AND m.lvl3_id=:lvl3",nativeQuery = true)
	public List<Menu> selectByOneTwoThree(@Param("lvl1") int lvl1,@Param("lvl2") int lvl2,@Param("lvl3") int lvl3);
	
}
