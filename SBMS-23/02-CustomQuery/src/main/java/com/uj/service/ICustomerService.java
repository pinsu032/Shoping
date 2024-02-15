package com.uj.service;

import org.springframework.stereotype.Service;

import com.uj.entity.Customer;

@Service
public interface ICustomerService {

	Boolean save(Customer customer);
	
	Boolean update(Customer customer);
	
	Boolean removeCustomer(Integer id);
}
