package com.uj.service;

import java.util.List;

import com.uj.entity.Quize;

public interface IQuize {

	Boolean create(Quize quize);
	
	List<Quize> getAllQuize();
	
	Quize getQuize(Integer qid);
}
