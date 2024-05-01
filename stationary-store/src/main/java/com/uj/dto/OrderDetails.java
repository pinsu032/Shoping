package com.uj.dto;

import lombok.Data;

@Data
public class OrderDetails {
	
	private String email;
	private String category;
	private Integer pid;
	private String productName;
    private Double price;	
	private Integer noOfProduct;
}
