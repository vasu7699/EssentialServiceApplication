package com.esa.kl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Hospital {
	@Id
	Integer id;
	String name;
	String description;
	Address address;
	Feedback feedback;
}
