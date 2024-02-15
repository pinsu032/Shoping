package com.uj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uj.enity.Question;
import com.uj.repo.QuestionRepo;

@Service
public class QuestionService implements IQuestion {
	
	private QuestionRepo questionRepo;

	public QuestionService(QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	@Override
	public Boolean create(Question question) {
		Question save = questionRepo.save(question);
		if(save != null)
			return true;
		
		return false;
	}

	@Override
	public List<Question> getAllQuestions() {
		List<Question> allQuestions = questionRepo.findAll();
		return allQuestions;
	}

	@Override
	public Question getQuestion(Integer id) {
		Optional<Question> questionOptional = questionRepo.findById(id);
		if(questionOptional.isPresent())
			return questionOptional.get();
		
		return null;
	}

	@Override
	public List<Question> getQuizeQuestions(Integer quizeId) {
		List<Question> findByQuizeId = questionRepo.findByQuizeId(quizeId);
		
		return findByQuizeId;
	}

}
