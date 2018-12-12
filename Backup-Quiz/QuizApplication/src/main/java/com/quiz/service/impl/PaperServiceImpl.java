package com.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.model.Paper;
import com.quiz.repo.PaperRepo;
import com.quiz.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	public PaperRepo paperRepo;

	@Override
	public List<Paper> getAllPaper() {

		return paperRepo.findAll();
	}

	@Override
	public void addPaper(Paper paper) {
		paperRepo.save(paper);

	}

}
