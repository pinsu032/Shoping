package com.uj.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.OrderDetails;
import com.uj.dto.OrderRes;
import com.uj.dto.OrderResponse;
import com.uj.service.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private IOrderService service;
	
	@PostMapping("/place")
	public ResponseEntity<OrderRes> placeOrder(@RequestBody OrderDetails details){
		Boolean placeOrder = service.placeOrder(details);
		System.out.println(placeOrder);
		OrderRes res = new OrderRes();
		String status = "";
		if(placeOrder) {
			status = "Order placed..";
		}
		else {
			status = "Order not placed";
		}
		res.setStatus(status);
		return new ResponseEntity<OrderRes>(res,HttpStatus.OK);
	}
	
	@GetMapping("/get/{email}")
	public ResponseEntity<?> getOrderByEmail(@PathVariable("email") String email){
		List<OrderResponse> fetchAllOrders = service.fetchOrderByEmail(email);
		System.out.println(fetchAllOrders);
		return new ResponseEntity<List<OrderResponse>>(fetchAllOrders,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrders(){
		List<OrderResponse> fetchAllOrders = service.fetchAllOrders();
		
		return new ResponseEntity<List<OrderResponse>>(fetchAllOrders,HttpStatus.OK);
	}
	
	@GetMapping("/change/{id}")
	public ResponseEntity<OrderRes> changeStatus(@PathVariable("id") Integer id){
		OrderRes status = service.changeStatus(id);
		
		return new ResponseEntity<OrderRes>(status,HttpStatus.OK);
	} 
	
	
}
