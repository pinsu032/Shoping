package com.uj.restcontroller;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.entity.Customer;
import com.uj.service.ICustomerService;

@RestController
@RequestMapping("cust")
public class CustomerController {

	private ICustomerService service;
	
	@Autowired
	public CustomerController(ICustomerService service) {
		this.service = service;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody Customer customer){
		String msg = null;
		Boolean save = service.save(customer);
		if(save) 
			msg = "Customer saved successfully......";
		else
			msg = "Something went wrong";
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody Customer customer){
		String msg = null ;
		Boolean update = service.update(customer);
		if(update) 
			msg = "Customer updated successfully......";
		else
			msg = "Something went wrong";
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		String msg = null ;
		Boolean removeCustomer = service.removeCustomer(id);
		if(removeCustomer) 
			msg = "Customer deleted successfully......";
		else
			msg = "Something went wrong";
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
}
