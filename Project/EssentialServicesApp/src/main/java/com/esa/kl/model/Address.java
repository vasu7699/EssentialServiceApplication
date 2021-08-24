package com.esa.kl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
	String emailId;
	double phone;
	String location;
	String city;
	String state;
	String country;
	double pincode;

}
