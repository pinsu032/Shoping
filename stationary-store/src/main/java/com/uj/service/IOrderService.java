package com.uj.service;

import java.util.List;

import com.uj.dto.OrderDetails;
import com.uj.dto.OrderRes;
import com.uj.dto.OrderResponse;

public interface IOrderService {

	public Boolean placeOrder(OrderDetails details);
	
	List<OrderResponse> fetchAllOrders();

	public OrderRes changeStatus(Integer id);

	public List<OrderResponse> fetchOrderByEmail(String email);
}
