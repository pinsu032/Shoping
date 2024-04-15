package com.uj.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.OrderDetails;
import com.uj.dto.OrderResponse;
import com.uj.service.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private IOrderService service;
	
	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDetails details){
		Boolean placeOrder = service.placeOrder(details);
		if(placeOrder) {
			return new ResponseEntity<String>("Order placed ..",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Order not placed",HttpStatus.OK);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrders(){
		List<OrderResponse> fetchAllOrders = service.fetchAllOrders();
		
		return new ResponseEntity<List<OrderResponse>>(fetchAllOrders,HttpStatus.OK);
	}
	
	
}
