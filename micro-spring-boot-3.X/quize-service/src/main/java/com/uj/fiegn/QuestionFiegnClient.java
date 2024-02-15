package com.uj.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uj.dto.Question;

@FeignClient(name = "question-service")
public interface QuestionFiegnClient {

	@GetMapping("question/quize/{quizeId}")
    List<Question> getQuizeQuestions(@PathVariable("quizeId") Integer quizeId);
}
