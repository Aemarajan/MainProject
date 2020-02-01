package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.*;

public interface PrivilegeRepository extends JpaRepository<Privilege,Integer> {

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM privilege p where p.user_id=:id AND p.inn=:inn",nativeQuery=true)
	public List<Privilege> findByUserId(@Param("id")int id,@Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM privilege p where p.user_id=:id",nativeQuery=true)
	public List<Privilege> findAllByUser(@Param("id")int id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE privilege p SET p.inn=:inn WHERE p.user_id=:user_id AND p.menu_id=:menu_id",nativeQuery=true)
	public void update(@Param("user_id")int user_id,@Param("menu_id")int menu_id,@Param("inn")int inn);
}
