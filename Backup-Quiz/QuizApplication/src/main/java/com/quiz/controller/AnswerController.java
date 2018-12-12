package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Answer; 
import com.quiz.service.AnswerService;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AnswerController {

	@Autowired 
	
	public AnswerService ansSer; 
	
	
	@GetMapping("/getAnswerBaseInQuestionId/{questionId}")
	public List<Answer> getAllQuestionInfo(@PathVariable("questionId")int questionId){
	 return ansSer.getAllAnswer(questionId);
	}
	
	
 
}
	