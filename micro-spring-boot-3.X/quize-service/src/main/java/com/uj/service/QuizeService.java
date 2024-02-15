package com.uj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uj.entity.Quize;
import com.uj.fiegn.QuestionFiegnClient;
import com.uj.repo.QuizeRepo;

@Service
public class QuizeService implements IQuize {
	
	private QuizeRepo quizeRepo;
	private QuestionFiegnClient client;
	
	public QuizeService(QuizeRepo quizeRepo, QuestionFiegnClient client) {
		super();
		this.quizeRepo = quizeRepo;
		this.client = client;
	}

	@Override
	public Boolean create(Quize quize) {
		Quize save = quizeRepo.save(quize);
		if(save != null)
			return true;
		
		return false;
	}

	@Override
	public List<Quize> getAllQuize() {
		List<Quize> allQuize = quizeRepo.findAll();
		List<Quize> collect = allQuize.stream().map((q) -> {
			q.setQuestions(client.getQuizeQuestions(q.getQid()));
			return q;
		}).collect(Collectors.toList());
		return collect;
	}

	@Override
	public Quize getQuize(Integer qid) {
		Optional<Quize> quize = quizeRepo.findById(qid);
		if(quize.isPresent()) {
		   quize.get().setQuestions(client.getQuizeQuestions(qid));
		   return quize.get();
		}
		   
		
		return null;
	}

}
