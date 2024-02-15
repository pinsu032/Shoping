package com.uj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.enity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByQuizeId(Integer quizeId);

}
