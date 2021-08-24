package com.esa.kl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esa.kl.model.Covidcenter;

@Service
public interface ICovidcenterService {
	List<Covidcenter> getAll();
	List<Covidcenter> getByLocationOrPincode(String location, String city, double pincode);
	List<Covidcenter> getByDescription(String description);

}
