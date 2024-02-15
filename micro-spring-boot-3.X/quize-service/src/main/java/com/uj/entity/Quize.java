package com.uj.entity;

import java.util.List;

import com.uj.dto.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Quize {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qid;
	private String title;
	
	@Transient
	private List<Question> questions;
}
