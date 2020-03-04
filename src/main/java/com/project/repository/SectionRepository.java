package com.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Section;

public interface SectionRepository extends JpaRepository<Section,Integer>  {

	@Transactional
	@Modifying
	@Query(value="UPDATE section_master s SET s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void updateInn(@Param("id")int id,@Param("inn") int i);

}
