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

import com.uj.entity.Quize;
import com.uj.service.QuizeService;

@RestController
@RequestMapping("/quize")
public class QuizeController {
	
	private QuizeService quizeService;

	public QuizeController(QuizeService quizeService) {
		super();
		this.quizeService = quizeService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuize(@RequestBody Quize quize){
		Boolean create = quizeService.create(quize);
		if(create)
			return new ResponseEntity<String>("Quize created with id",HttpStatus.CREATED);
		else {
			return new ResponseEntity<String>("Not created",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Quize>> getAllQuize(){
		List<Quize> allQuize = quizeService.getAllQuize();
		
		return new ResponseEntity<>(allQuize,HttpStatus.OK);
	}
	
	@GetMapping("/one/{qid}")
	public ResponseEntity<Quize> getAllQuize(@PathVariable("qid") Integer qid){
		Quize quize = quizeService.getQuize(qid);
		return new ResponseEntity<>(quize,HttpStatus.OK);
	}
	

}
