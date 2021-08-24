package com.esa.kl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esa.kl.model.Hospital;

@Service
public interface IHospitalService {
	void addFeedback(int id,int ratings);
	List<Hospital> getAllHospitals();
    List<Hospital> getHospitalByName(String name);
	List<Hospital> getHospitalByFeedback(int rating);
	List<Hospital> getHospitalByLocation(String location, String city);
	List<Hospital> getHospitalByPinCode(double pincode);
	//List<Hospital> getHospitalByLacationAndFeedback(String location, String city, int rating);
	List<Hospital> gethospitalByspecialization(String specialization);
	List<Hospital> getHospitalByLocationAndFeedbackRatings(String location, String city, int rating);
}
