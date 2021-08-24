package com.esa.kl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esa.kl.model.Covidcenter;
import com.esa.kl.repository.ICovidcenterRepository;

@Service
public class CovidcenterImpl implements ICovidcenterService {
	
	@Autowired
	ICovidcenterRepository iCovidcenterRepository;

	@Override
	public List<Covidcenter> getAll() {
		// TODO Auto-generated method stub
		return iCovidcenterRepository.findAll() ;
	}

	@Override
	public List<Covidcenter> getByLocationOrPincode(String location, String city, double pincode) {
		// TODO Auto-generated method stub
		return iCovidcenterRepository.findByAddressLocationAndAddressCityOrAddressPincode(location, city, pincode);
	}

	@Override
	public List<Covidcenter> getByDescription(String description) {
		// TODO Auto-generated method stub
		return iCovidcenterRepository.findByDescription(description);
	}

}
