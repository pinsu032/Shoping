package com.uj.model;

import lombok.Data;

@Data
public class Book {

	private Integer id;
	private String name;
	private Author author;
}
