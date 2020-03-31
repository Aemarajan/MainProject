package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.User;;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);
	
	User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user u where u.privilege_provide=:pp",nativeQuery=true)
	List<User> selectByPP(@Param("pp")int i);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user u where u.user_id=:id",nativeQuery=true)
	List<User> findById(@Param("id")int id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user u where u.password=:password",nativeQuery=true)
	List<User> findByPassword(@Param("password")String password);

	@Transactional
	@Modifying
	@Query(value="UPDATE user u SET u.privilege_provide=:pp WHERE u.user_id=:id",nativeQuery=true)
	void updatePrivilegeProvide(@Param("id")int id,@Param("pp")int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE user u SET u.password=:password WHERE u.user_id=:id",nativeQuery=true)
	void updatePassword(@Param("password")String password,@Param("id")User user);
	
}
