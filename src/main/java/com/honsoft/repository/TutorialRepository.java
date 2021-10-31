package com.honsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honsoft.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	public List<Tutorial> findByPublished(boolean published);
	public List<Tutorial> findByTitleContaining(String title);
}
