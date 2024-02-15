package com.uj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uj.entity.Customer;
import com.uj.repo.CustomerRepo;

@Service
public class CustomerServiveImpl  implements ICustomerService{

	private CustomerRepo repo;
	
	@Autowired
	public CustomerServiveImpl(CustomerRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Boolean save(Customer customer) {
		Customer cust = repo.save(customer);
		if(cust.getId() !=  null)
			return true;
		
		return false;
	}

	@Override
	public Boolean update(Customer customer) {
		if (repo.existsById(customer.getId())) {
			try {
				repo.updateCustomerName(customer.getName(), customer.getId());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Boolean removeCustomer(Integer id) {
		if (repo.existsById(id)) {
			try {
				repo.removeCustomer(id);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

}
