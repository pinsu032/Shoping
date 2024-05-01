package com.uj.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderResponse {

	private Integer orderId;
	private String category;
	private String productName;
	private Integer noOfProduct;
    private Double totalPrice;	
	private LocalDateTime creationTime;
	private LocalDateTime createdBy;
	private String status;
}
