package com.uj.service;

import java.util.List;

import com.uj.dto.OrderDetails;
import com.uj.dto.OrderResponse;

public interface IOrderService {

	public Boolean placeOrder(OrderDetails details);
	
	List<OrderResponse> fetchAllOrders();
}
