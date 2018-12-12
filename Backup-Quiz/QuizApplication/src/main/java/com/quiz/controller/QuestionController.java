package com.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RestController;

 
import com.quiz.model.Answer;
import com.quiz.model.Category;
import com.quiz.model.Question;
import com.quiz.repo.QuestionRepo;
import com.quiz.service.AnswerService;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("/question") 
public class QuestionController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	public Question question = null;

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
		question = questionImpl.addQuestion(question);

	}

	@GetMapping("/getQuestionBaseCategory/{categoryId}")
	public List<Question> getQuestionBaseCategoryId(@PathVariable("categoryId") int categoryId) {
		return questionImpl.getQuestionBaseCategoryId(categoryId);
	}

	@GetMapping("/getQuestionBaseQuestionId/{questionId}")
	public String getQuestionBaseQuestionId(@PathVariable("questionId") int questionId) {

		return questionImpl.getQuestionTextBaseQuestionId(questionId);

	}
	
	@GetMapping("/getQuestionInfo")
	public List<Question> getAllQuestionInfo(){
		return questionImpl.getAllQuestion();
	}
	@Autowired
	public QuestionRepo questionRepo;

	@DeleteMapping("/deleteAllInCategoryId")
	public void delete() {	
	         long categoryId=3;
			Optional<Question> optionCategory = questionRepo.findById(categoryId);
			if (optionCategory.isPresent()) {
				questionRepo.delete(optionCategory.get());
 			   logger.info("--------------Delete Successfully -------------:");
		}
	}
	
}
