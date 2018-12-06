package com.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.model.Answer;
import com.quiz.repo.AnswerRepo;
import com.quiz.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	public AnswerRepo ansRepo;
	
	@Override
	public void addAnswer(Answer answer) {
		 		ansRepo.save(answer);
	}

}
