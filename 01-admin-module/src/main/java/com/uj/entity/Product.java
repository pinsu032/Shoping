package com.uj.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String productType;
	private String productName;
	private Double productPrice;
	private Integer quantity;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private ProductCategory productCategory;
	
	@Column(updatable = false)
	private String createdBy;
	@Column(insertable = false)
	private String updatedBy;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
