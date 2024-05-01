package com.uj.dto;

import lombok.Data;

@Data
public class ProductResponse {

	private Integer pid;
	private String category;
	private String productName;
	private Double productPrice;
	private String filePath;
	private Integer quantity;
	private String stockStatus;
	private boolean stock;
}
