package com.esa.kl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Registration {
	
	Integer id;
	String category;
	String name;
	String description;
	Address address;
	
}
