package com.project.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.CSDMapping;
import com.project.model.UserProfile;

public interface ProfileRepository extends JpaRepository<UserProfile,Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE user_profile u SET u.dob=:dob, u.blood_id=:blood,u.religion_id=:religion,u.community_id=:comm WHERE u.user_id=:user",nativeQuery=true)
	public void updatePersonal(@Param("dob")Date dob, @Param("blood")int blood, @Param("religion")int religion, @Param("comm")int community, @Param("user")int id);

	@Transactional
	@Modifying
	@Query(value="UPDATE user_profile u SET u.door_no=:door, u.line1=:line1, u.line2=:line2, u.line3=:line3, u.csd=:csd, u.pincode=:pin, u.permanent=:permanent,"
			+ "u.p_door_no=:pdoor, u.p_line1=:pline1, u.p_line2=:pline2, u.p_line3=:pline3, u.p_csd=:pcsd, u.p_pincode=:ppin WHERE u.user_id=:id",nativeQuery=true)
	public void updateAddress(@Param("id")int id, @Param("door")String door, @Param("line1")String line1, @Param("line2")String line2, @Param("line3")String line3, 
			@Param("csd")CSDMapping csd, @Param("pin")int pincode, @Param("permanent")int permanent, @Param("pdoor")String pdoor, @Param("pline1")String pline1, 
			@Param("pline2")String pline2, @Param("pline3")String pline3, @Param("pcsd")CSDMapping pcsd,@Param("ppin")int ppin);
	
	
}
