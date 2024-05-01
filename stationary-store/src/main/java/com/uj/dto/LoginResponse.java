package com.uj.dto;

import lombok.Data;

@Data
public class LoginResponse {

	private String email;
	private String msg;
	private String token;
	private String role;
	private String fullName;
}
