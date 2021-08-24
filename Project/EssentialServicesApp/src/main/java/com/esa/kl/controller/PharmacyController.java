package com.esa.kl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esa.kl.exception.PharmacyNotFoundException;
import com.esa.kl.model.Pharmacy;
import com.esa.kl.service.IPharmacyService;

@RestController
@RequestMapping("/esa")
public class PharmacyController {
	
	@Autowired
	IPharmacyService iPharmacyService;
	@GetMapping("/pharmacy")
	ResponseEntity<List<Pharmacy>> getAll(){
		List<Pharmacy> npharmacy=iPharmacyService.getAll();
		if(npharmacy.size()==0)
			throw new PharmacyNotFoundException("no pharmacy found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all pharmacies");
		return ResponseEntity.ok().headers(headers).body(npharmacy);
		
	}
	@GetMapping("/pharmacy/get-by-address/{location}/{city}/{pincode}")
	ResponseEntity<List<Pharmacy>> getByLocationOrPincode(@PathVariable("location") String location,@PathVariable("city") String city,@PathVariable("pincode") double pincode){
		List<Pharmacy> npharmacy=iPharmacyService.getByLocationOrPincode(location, city, pincode);
		if(npharmacy.size()==0)
			throw new PharmacyNotFoundException("no pharmacy found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all pharmacies by address");
		return ResponseEntity.ok().headers(headers).body(npharmacy);
	}
	@GetMapping("/pharmacy/get-by-feedback/{rating}")
	ResponseEntity<List<Pharmacy>> getByFeedback(@PathVariable("rating") int rating){
		List<Pharmacy> npharmacy=iPharmacyService.getByFeedback(rating);
		if(npharmacy.size()==0)
			throw new PharmacyNotFoundException("no pharmacy found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all pharmaciesPUT by feedback");
		return ResponseEntity.ok().headers(headers).body(npharmacy);
	}
	@PutMapping("/pharmacy/add-feedback/{id}/{rating}")
	ResponseEntity<Void> addFeedback(@PathVariable("id") int id,@PathVariable("rating") int ratings){
		iPharmacyService.addFeedback(id, ratings);
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "add feedback");
		return ResponseEntity.ok().headers(headers).body(null);
	}

}
