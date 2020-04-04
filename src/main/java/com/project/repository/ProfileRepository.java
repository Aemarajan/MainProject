package com.project.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.UserProfile;

public interface ProfileRepository extends JpaRepository<UserProfile,Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE user_profile u SET u.dob=:dob, u.blood_id=:blood,u.religion_id=:religion,u.community_id=:comm WHERE u.user_id=:user",nativeQuery=true)
	public void updatePersonal(@Param("dob")Date dob, @Param("blood")int blood, @Param("religion")int religion, @Param("comm")int community, @Param("user")int id);

}
