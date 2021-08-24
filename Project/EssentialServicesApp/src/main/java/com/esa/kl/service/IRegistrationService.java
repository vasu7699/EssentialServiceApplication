package com.esa.kl.service;

import org.springframework.stereotype.Service;

import com.esa.kl.model.Registration;

@Service
public interface IRegistrationService {
	
	String addNew(Registration user);
	//void updateUser(int id);
	//void addFeedback(int id,int ratings);

}
