package com.honsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honsoft.entity.Tutorial;
import com.honsoft.service.TutorialService;

@RestController
@RequestMapping("/api")
public class TutorialController {
	@Autowired
	TutorialService tutorialService;
	
	@GetMapping("/tutorials")
	public List<Tutorial> getAllTutorials(){
		return tutorialService.getAllTutorials();
	}
	
	@GetMapping("/tutorials/{id}")
	public Tutorial getTutorialById(@PathVariable("id") long id) {
		return tutorialService.getTutorialById(id);
	}
	
	@PostMapping("/tutorials")
	public void createTutorial(@RequestBody Tutorial tutorial) {
		tutorialService.createTutorial(tutorial);
	}
	
	@PutMapping("/tutorials/{id}")
	public void updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		tutorialService.updateTutorial(tutorial);
	}
	
	@DeleteMapping("/tutorials/{id}")
	public void deleteTutorial(@PathVariable("id") long id) {
		tutorialService.deleteTutorial(id);
	}
	
	@DeleteMapping("/tutorials")
	public void deleteAllTutorials() {
		tutorialService.deleteAllTutorials();
	}
	
	@GetMapping("/tutorials/published")
	public List<Tutorial> getTutorialsPublished(){
		return tutorialService.getTutorialsPublished(true);
	}
}
