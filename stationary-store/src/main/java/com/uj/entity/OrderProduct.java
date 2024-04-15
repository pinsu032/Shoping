package com.uj.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "category")
	private String category;
	@Column(name= "product_name")
	private String productName;
	@Column(name = "no_of_product")
	private Integer noOfProduct;
	@Column(name = "total_price")
	private Double totalPrice;
	
	@CreationTimestamp
	@Column(name = "creation_time",updatable = false)
	private LocalDateTime creationTime;
	@UpdateTimestamp
	@Column(name = "update_time",insertable = false)
	private LocalDateTime upadteTime;
	@Column(name = "created_by",updatable = false)
	private LocalDateTime createdBy;
	@Column(name = "updated_by",insertable = false)
	private LocalDateTime updatedBy;
	
	
}
