package com.uj.service;

import java.util.List;

import com.uj.enity.Question;

public interface IQuestion {

	Boolean create(Question question);
	
	List<Question> getAllQuestions();
	
	Question getQuestion(Integer id);
	
	List<Question> getQuizeQuestions(Integer quizeId);
}
