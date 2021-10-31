package com.honsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honsoft.entity.Tutorial;
import com.honsoft.repository.TutorialRepository;

@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;
	
	public List<Tutorial> getAllTutorials(){
		return tutorialRepository.findAll();
	}
	
	public Tutorial getTutorialById(long id) {
		return tutorialRepository.getById(id);
	}
	
	public void createTutorial(Tutorial tutorial) {
		tutorialRepository.save(tutorial);
	}
	
	public void updateTutorial(Tutorial tutorial) {
		tutorialRepository.save(tutorial);
	}
	
	public void deleteTutorial(long id) {
		tutorialRepository.deleteById(id);
	}
	
	public void deleteAllTutorials() {
		tutorialRepository.deleteAll();
	}
	
	public List<Tutorial> getTutorialsPublished(boolean published) {
		return tutorialRepository.findByPublished(published);
	}
}
