package com.uj.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uj.dao.UserDaoImpl;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private UserDaoImpl dao;
	
	Logger log = LoggerFactory.getLogger(Runner.class);
	
	@Override
	public void run(String... args) throws Exception {
//		boolean save = dao.save();
//		if(save)
//           log.info("User registered successfully.....");
//		else
//			log.info("User doesn't registered");
		
		Integer count = dao.getEmployee();
		
		if(count>0)
			log.info("Employees present in company is {}",count);
		else
			log.info("There is no employee present in this company.....");
	}

}
