package com.uj.dto;

import lombok.Data;

@Data
public class EmailDetails {

	private String recipient;
	private String msgBody;
	private String subject;
}
