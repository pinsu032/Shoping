package com.uj.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String category;
	@OneToMany(mappedBy = "productCategory" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Product> product;
	
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
