package com.quiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.service.AnswerService;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	   public Question question=null;
	@Autowired
	public QuestionService questionImpl;

	@Autowired
	public AnswerService ansSer;

	@PostMapping("/addquestion")
	public void addQuestion(@RequestBody Question question) {
		logger.info("################## QuestionCategory---->" + question.getQuestionCategory());
		logger.info("$$$$$$$$$$$$$$$$$$$$$ Question Text----->" + question.getQuestionText());
		logger.info("*********************Question Subcategory------>" + question.getSubcategory());
		for (Answer a : question.getOptions()) {

			ansSer.addAnswer(a);
		}

	  question= questionImpl.addQuestion(question);

	}

}
