package com.uj.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uj.dto.EmailDetails;
import com.uj.dto.OrderDetails;
import com.uj.dto.OrderRes;
import com.uj.dto.OrderResponse;
import com.uj.entity.OrderProduct;
import com.uj.repo.OrderRepo;
import com.uj.repo.UserMasterRepo;
import com.uj.restcontroller.AdminController;
import com.uj.util.EmailUtil;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepo repo;
	@Autowired
	private EmailUtil util;
	@Autowired
	private IAdminOperation adminOperation;
	@Autowired 
	private AdminController client;
	
	@Override
	public Boolean placeOrder(OrderDetails details) {
		Integer quantity = adminOperation.getQuantity(details.getPid());
		if (quantity > 0 && quantity >= details.getNoOfProduct()) {
			Double totalPrice = details.getNoOfProduct() * details.getPrice();
			OrderProduct product = new OrderProduct();
			BeanUtils.copyProperties(details, product);
			product.setUserId(details.getEmail());
			product.setTotalPrice(totalPrice);
			product.setStatus("NOT PAID");
			OrderProduct save = repo.save(product);

			quantity = quantity - details.getNoOfProduct();

			ResponseEntity<?> updateProductQuantity = client.updateQuantity(details.getPid(), quantity);
			System.out.println("===========" + updateProductQuantity);
			
			if(save.getOrderId() != null) {
				//String msg = sentMailToAdminAndCustomer(product);
				//System.out.println("Email Status::::"+msg);
				return true;
			}
		}
		return false;
	}

	private String sentMailToAdminAndCustomer(OrderProduct product) {
		EmailDetails details = new EmailDetails();
		details.setRecipient("pinsusingh012@gmail.com");
		details.setSubject("Order Summary");
		String fileName = "Mail_Body.txt";
		details.setMsgBody(readEmailBody(product.getProductName(), product.getTotalPrice(), fileName));
		
		boolean sendMail = util.sendMail(details);

		if (sendMail)
			return "Password sent to your registered email.";
		
		return null;
	}
	
	private String readEmailBody(String productName,Double totalPrice,String fileName) {
		String body = null;
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			StringBuffer buffer = new StringBuffer();
			String line = br.readLine();
			
			while(line != null) {
				buffer.append(line);
				line = br.readLine();
			}
			br.close();
			body = buffer.toString();
			body = body.replace("{productName}", productName);
			body = body.replace("{totalPrice}" , totalPrice.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	@Override
	public List<OrderResponse> fetchAllOrders() {
		List<OrderProduct> findAll = repo.findAll();
		
		List<OrderResponse> listOrder = new ArrayList<>();
		findAll.forEach( order -> {
		  OrderResponse  resp = new OrderResponse();
		  BeanUtils.copyProperties(order, resp);
		  listOrder.add(resp);
		});
		return listOrder;
	}

	@Override
	public OrderRes changeStatus(Integer id) {
		Optional<OrderProduct> findById = repo.findById(id);
		OrderRes res = new OrderRes();
		if(findById.isPresent()) {
			OrderProduct orderProduct = findById.get();
			orderProduct.setStatus("PAID");
			OrderProduct save = repo.save(orderProduct);
			if(save.getStatus()== "PAID") {
				res.setStatus("PAID");
			}
		}
		return res;
	}

	@Override
	public List<OrderResponse> fetchOrderByEmail(String email) {
		List<OrderProduct> findByUser_UserId = repo.findByUserId(email);
		List<OrderResponse> listOrder = new ArrayList<>();
		findByUser_UserId.forEach( order -> {
		  OrderResponse  resp = new OrderResponse();
		  BeanUtils.copyProperties(order, resp);
		  listOrder.add(resp);
		});
		return listOrder;
	}

}
