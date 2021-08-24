package com.esa.kl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esa.kl.exception.CovidcenterNotFundException;
import com.esa.kl.model.Covidcenter;

import com.esa.kl.service.ICovidcenterService;

@RestController
@RequestMapping("/esa")
public class CovidcenterController {
	@Autowired
	ICovidcenterService iCovidcenterService;
	
	@GetMapping("/covidcenters")
	ResponseEntity<List<Covidcenter>> getAll(){
		List<Covidcenter> ncovid=iCovidcenterService.getAll();
		if(ncovid.size()==0)
			throw new CovidcenterNotFundException("No covid center found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all covid center");
		return ResponseEntity.ok().headers(headers).body(ncovid);
	}
	@GetMapping("/covidcenters/get-by-address/{location}/{city}/{pincode}")
	ResponseEntity<List<Covidcenter>> getByLocationOrPincode(@PathVariable("location") String location,@PathVariable("city") String city,@PathVariable("pincode") double pincode){
		List<Covidcenter> ncovid=iCovidcenterService.getByLocationOrPincode(location, city, pincode);
		if(ncovid.size()==0)
			throw new CovidcenterNotFundException("No covid center found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all covid centers by address");
		return ResponseEntity.ok().headers(headers).body(ncovid);
	}
	@GetMapping("/covidcenters/get-by-description/{description}")
	ResponseEntity<List<Covidcenter>> getByDescription(@PathVariable("description") String description){
		List<Covidcenter> ncovid=iCovidcenterService.getByDescription(description);
		if(ncovid.size()==0)
			throw new CovidcenterNotFundException("No covid center found");
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Getting all by description");
		return ResponseEntity.ok().headers(headers).body(ncovid);
		
	}
	

}
