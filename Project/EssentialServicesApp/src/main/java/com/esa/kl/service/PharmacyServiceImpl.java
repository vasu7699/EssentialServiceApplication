package com.esa.kl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esa.kl.model.Feedback;
import com.esa.kl.model.Pharmacy;
import com.esa.kl.repository.IPharmacyRepository;

@Service
public class PharmacyServiceImpl implements IPharmacyService {
	
	@Autowired
	IPharmacyRepository iPharmacyRepository;

	@Override
	public List<Pharmacy> getAll() {
		// TODO Auto-generated method stub
		return iPharmacyRepository.findAll();
	}

	@Override
	public List<Pharmacy> getByLocationOrPincode(String location, String city, double pincode) {
		// TODO Auto-generated method stub
		return iPharmacyRepository.findByAddressLocationAndAddressCityOrAddressPincode(location, city,pincode);
	}

	@Override
	public List<Pharmacy> getByFeedback(int rating) {
		// TODO Auto-generated method stub
	return iPharmacyRepository.findByFeedbackRatings(rating);
	}

	@Override
	public void addFeedback(int id, int ratings) {
		// TODO Auto-generated method stub
		Pharmacy pharmacy=iPharmacyRepository.findById(id).orElse(null);
		Feedback f=new Feedback();
		f.setRatings(ratings);
		pharmacy.setFeedback(f);
		iPharmacyRepository.save(pharmacy);
	}



}
