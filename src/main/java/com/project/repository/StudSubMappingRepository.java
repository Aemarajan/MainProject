package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.StudSubMapping;

public interface StudSubMappingRepository extends JpaRepository<StudSubMapping, Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE student_subject_mapping s SET s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void updateInn(@Param("id")int id,@Param("inn") int i);

	@Transactional
	@Modifying
	@Query(value="SELECT * FROM student_subject_mapping s WHERE s.user=:user AND s.semester=:sem",nativeQuery=true)
	List<StudSubMapping> selectAllSubjectsByUserId(@Param("user")int user,@Param("sem") int sem);

}
