package com.uj.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.enity.Question;
import com.uj.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuestion(@RequestBody Question question){
		Boolean create = questionService.create(question);
		if(create)
			return new ResponseEntity<>("Question created" , HttpStatus.CREATED);
		else 
			return new ResponseEntity<>("Not created" , HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions(){
		List<Question> allQuestions = questionService.getAllQuestions();
		
		return new ResponseEntity<List<Question>>(allQuestions,HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Question> getAllQuestions(@PathVariable("id") Integer id){
		Question question = questionService.getQuestion(id);
		
		return new ResponseEntity<>(question,HttpStatus.OK);
	}
	
	@GetMapping("/quize/{quizeId}")
	public ResponseEntity<List<Question>> getQuizeQuestions(@PathVariable("quizeId") Integer quizeId){
		List<Question> quizeQuestions = questionService.getQuizeQuestions(quizeId);
		
		return new ResponseEntity<List<Question>>(quizeQuestions,HttpStatus.OK);
	}
	
}
