package com.uj.entity;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UsersMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String fullName;
	private String email;
	private Long mobile;
	private String gender;
	private LocalDate dob;
	private String password;
	private String address;
	private String role;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	@CreationTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;
	private String createdBy;
	private String updatedBy;
}
