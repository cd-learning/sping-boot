package com.quiz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Paper;
import com.quiz.model.PaperQuestion;
import com.quiz.service.PaperQuestionService;
import com.quiz.service.PaperService;

@RestController
@RequestMapping("/paper")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PaperController {
	private static final Logger logger = LoggerFactory.getLogger(PaperController.class);

	@Autowired
	public PaperService paperSer;

	@Autowired
	public PaperQuestionService paperQuestionService;

	@PostMapping("/paperQuestion")
	public void addQuestion(@RequestBody Paper paper) {

		for (PaperQuestion pq : paper.getPaperQuestionList()) {
			paperQuestionService.addPaperQuestion(pq);
		}
		paperSer.addPaper(paper);
		logger.info("######## ADD Successfully....................");
	}

	@GetMapping("/getPaperInfo")
	public List<Paper> getPaperInfo() {
		return paperSer.getAllPaper();
	}
}
