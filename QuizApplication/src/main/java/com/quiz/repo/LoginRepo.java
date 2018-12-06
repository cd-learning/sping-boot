package com.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {
	

}
