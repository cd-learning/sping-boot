package com.quiz.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.quiz.model.Login;
import com.quiz.repo.LoginRepo;
import com.quiz.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepo loginRepo;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void addUser(Login login) {
		loginRepo.saveAndFlush(login);
	 
	}
	 
}
