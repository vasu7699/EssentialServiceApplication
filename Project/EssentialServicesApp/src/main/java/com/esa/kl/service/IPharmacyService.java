package com.esa.kl.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.esa.kl.model.Pharmacy;
@Service
public interface IPharmacyService {
	
	List<Pharmacy> getAll();
	List<Pharmacy> getByLocationOrPincode(String location, String city, double pincode);
	List<Pharmacy> getByFeedback(int rating);
	void addFeedback(int id,int ratings);


}
