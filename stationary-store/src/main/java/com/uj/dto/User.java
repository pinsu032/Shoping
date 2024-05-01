package com.uj.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String fullName;
	private String email;
	private Long mobile;
	private String gender;
	private String password;
	private LocalDate dob;
	private String address;
	private String role;
	private LocalDate createdDate;
}
