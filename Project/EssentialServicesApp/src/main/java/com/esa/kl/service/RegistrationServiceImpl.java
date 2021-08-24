package com.esa.kl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esa.kl.model.Covidcenter;
import com.esa.kl.model.Hospital;
import com.esa.kl.model.Pharmacy;
import com.esa.kl.model.Registration;

import com.esa.kl.repository.ICovidcenterRepository;
import com.esa.kl.repository.IHospitalRepository;
import com.esa.kl.repository.IPharmacyRepository;
//import com.esa.kl.repository.ISchoolRepository;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
	@Autowired
	IHospitalRepository iHospitalRepository;
	@Autowired
	ICovidcenterRepository iCovidcenterRepository;
	@Autowired
	IPharmacyRepository iPharmacyRepository;
	

	@Override
	public String addNew(Registration user) {
		// TODO Auto-generated method stub
		if(user.getCategory().equalsIgnoreCase("hospital")) {
			Hospital hospital=new Hospital(user.getId(),user.getName(),user.getDescription(),user.getAddress(),null);
//			hospital.setId(user.getId());
//			hospital.setName(user.getName());
//			hospital.setDescription(user.getDescription());
//			hospital.setAddress(user.getAddress());
			iHospitalRepository.insert(hospital);
			return "added Hospital";
			
		}
		else if(user.getCategory().equalsIgnoreCase("covidcenter")) {
			Covidcenter c=new Covidcenter(user.getId(),user.getName(),user.getDescription(),user.getAddress(),null);
//			c.setId(user.getId());
//			c.setName(user.getName());
//			c.setDescription(user.getDescription());
//			c.setAddress(user.getAddress());
			iCovidcenterRepository.insert(c);
			return "add covid center";
		}
		
		else if(user.getCategory().equalsIgnoreCase("pharmacy")) {
			Pharmacy p=new Pharmacy(user.getId(),user.getName(),user.getDescription(),user.getAddress(),null);
//			p.setId(user.getId());
//			p.setName(user.getName());
//			p.setDescription(user.getDescription());
//			p.setAddress(user.getAddress());
			iPharmacyRepository.insert(p);
			return "add pharmacy";
		}
		
		return "invalid category";
		
		
		
	}


}
