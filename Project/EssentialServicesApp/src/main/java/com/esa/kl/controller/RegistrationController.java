package com.esa.kl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esa.kl.model.Registration;
import com.esa.kl.service.IRegistrationService;

@RestController
@RequestMapping("/esa")
public class RegistrationController {
	
	@Autowired
	IRegistrationService iRegistrationService;
	
	@PostMapping("/Registration")
	ResponseEntity<Registration> newRegistration(@RequestBody Registration user){
		
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.add("desc", "Adding user");
		String registration=iRegistrationService.addNew(user);
		ResponseEntity<Registration> responseregister=new ResponseEntity<Registration>(headers,HttpStatus.ACCEPTED);
		return responseregister;
	}	
	
	
	
	
	

}
