package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.RSSMapping;

public interface RSSMappingRepository extends JpaRepository<RSSMapping, Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE rss_mapping s SET s.inn=:inn WHERE s.id=:id",nativeQuery=true)
	void updateInn(@Param("id")int id,@Param("inn") int i);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM rss_mapping s WHERE s.regulation=:regulation AND s.semester=:semester AND s.subject=:subject",nativeQuery=true)
	List<RSSMapping> findRSSCombo(@Param("regulation") int regulation,@Param("semester") int semester,@Param("subject") int subject);
}
