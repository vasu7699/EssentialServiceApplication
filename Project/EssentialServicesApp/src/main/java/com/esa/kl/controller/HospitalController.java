package com.esa.kl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esa.kl.exception.HospitalNotFoundException;
import com.esa.kl.model.Hospital;
import com.esa.kl.service.IHospitalService;

@RestController
@RequestMapping("/esa")
public class HospitalController {
	@Autowired
	IHospitalService iHospitalService;
	
	@GetMapping("/hospitals")
	ResponseEntity<List<Hospital>>  getAllHospitals(){
		List<Hospital> nhospital=iHospitalService.getAllHospitals();
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all hspitals");
		return ResponseEntity.ok().headers(headers).body(nhospital);
	}
	
	@GetMapping("/hospitals/get-by-name/{name}")
    ResponseEntity<List<Hospital>> getHospitalByName(@PathVariable("name") String name){
    	List<Hospital> nhospital=iHospitalService.getHospitalByName(name);
    	if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by name");
		return ResponseEntity.ok().headers(headers).body(nhospital);
    }
	
	@GetMapping("/hospitals/get-by-rating/{rating}")
	ResponseEntity<List<Hospital>> getHospitalByFeedback(@PathVariable("rating")  int rating){
		List<Hospital> nhospital=iHospitalService.getHospitalByFeedback(rating);
		if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by feedback");
		return ResponseEntity.ok().headers(headers).body(nhospital);
	}
	
	@GetMapping("/hospitals/get-by-location/{location}/{city}")
	ResponseEntity<List<Hospital>> getHospitalByLocation(@PathVariable("location") String location,@PathVariable("city") String city){
		List<Hospital> nhospital=iHospitalService.getHospitalByLocation(location, city);
		if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by location");
		return ResponseEntity.ok().headers(headers).body(nhospital);
	}
	
	@GetMapping("/hospitals/get-by-pincode/{pincode}")
	ResponseEntity<List<Hospital>> getHospitalByPinCode(@PathVariable("pincode") double pincode){
		List<Hospital> nhospital=iHospitalService.getHospitalByPinCode(pincode);
		if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by pincode");
		return ResponseEntity.ok().headers(headers).body(nhospital);
		
	}
	
	@GetMapping("/hospitals/get-by-specialization/{specialization}")
	ResponseEntity<List<Hospital>> gethospitalByspecialization(@PathVariable("specialization") String specialization){
		List<Hospital> nhospital=iHospitalService.gethospitalByspecialization(specialization);
		if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by apecialization");
		return ResponseEntity.ok().headers(headers).body(nhospital);
	}
	
	@GetMapping("/hospitals/get-by-location-feedback/{location}/{city}/{rating}")
	ResponseEntity<List<Hospital>> getHospitalByLocationAndFeedbackRatings(@PathVariable("location") String location,@PathVariable("city") String city,@PathVariable("rating") int rating){
		List<Hospital> nhospital=iHospitalService.getHospitalByLocationAndFeedbackRatings(location, city, rating);
		if(nhospital.size()==0)
    		throw new HospitalNotFoundException("no Hospital found");
    	org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "get hospital by location and feedback");
		return ResponseEntity.ok().headers(headers).body(nhospital);
	}
	
	
	@PutMapping("/hospitals/add-feedback/{id}/{ratings}")
	ResponseEntity<Void> addFeedback(@PathVariable("id") int id, @PathVariable("ratings") int ratings){
		iHospitalService.addFeedback(id, ratings);
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "addd feedback to hospital");
		return ResponseEntity.ok().headers(headers).body(null);
	}
}
