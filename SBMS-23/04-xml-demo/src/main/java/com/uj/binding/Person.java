package com.uj.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Person {

	private int id;
	private String name;
	private Address address;
}
