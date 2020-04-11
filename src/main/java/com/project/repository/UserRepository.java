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
	@Query(value="SELECT * FROM user u where u.password=:password",nativeQuery=true)
	User findByPassword(@Param("password")String password);
	
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
	@Query(value="UPDATE user u SET u.privilege_provide=:pp WHERE u.user_id=:id",nativeQuery=true)
	void updatePrivilegeProvide(@Param("id")int id,@Param("pp")int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE user u SET u.password=:password WHERE u.user_id=:id",nativeQuery=true)
	void updatePassword(@Param("password")String password,@Param("id")int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE user u SET u.role=:role, u.name=:name, u.email=:email, u.username=:username, u.password=:password, u.privilege_provide=:privilege_provide, u.inn=:inn WHERE u.user_id=:id",nativeQuery=true)
	void updateUser(@Param("id")int id,@Param("role")String role,@Param("name")String name,@Param("email")String email,@Param("username")String username,@Param("password")String password,@Param("privilege_provide")int privilege_provide, @Param("inn")int inn);

	@Transactional
	@Modifying
	@Query(value="UPDATE user u SET u.inn=:i WHERE u.user_id=:id",nativeQuery=true)
	void updateInnZero(@Param("id")int id, @Param("i")int i);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user WHERE user_id!=:id",nativeQuery=true)
	List<User> findAllById(int id);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user WHERE role='admin'",nativeQuery=true)
	List<User> findAllAdministrators();

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user WHERE role='staff'",nativeQuery=true)
	List<User> findAllStaffs();

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM user WHERE role='student'",nativeQuery=true)
	List<User> findAllStudents();
	
}
