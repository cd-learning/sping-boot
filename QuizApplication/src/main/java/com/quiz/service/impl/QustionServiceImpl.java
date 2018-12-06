package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.model.Question;
import com.quiz.repo.QuestionRepo;
import com.quiz.service.QuestionService;
 @Service
public class QustionServiceImpl implements QuestionService {
	private static final Logger logger = LoggerFactory.getLogger(QustionServiceImpl .class);

	@Autowired
	QuestionRepo repo;
	List<Question> questionList=null;
	
 
	 
	@Override
	public Question addQuestion(Question question) {
		return repo.save(question);
	}
	@Override
	public List<Question> getQuestionBaseCategoryId(int questionId) {
		Optional<Question> optionalStudent =repo.findById((long) questionId);
	 	if(optionalStudent.isPresent())
	 	 questionList.add(optionalStudent.get());
	 	logger.info("@@@@@@@@@@@@@@@@@@@@@@@@   " +questionList.size() +"@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	 	return questionList;
	}  
	 
}
