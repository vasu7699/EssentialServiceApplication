package com.esa.kl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esa.kl.model.Feedback;
import com.esa.kl.model.Hospital;
import com.esa.kl.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {
	
	@Autowired
	IHospitalRepository iHospitalRepository;

	
	@Override
	public List<Hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		return iHospitalRepository.findAll();
	}

	@Override
	public List<Hospital> getHospitalByName(String name) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByName(name);
	}

	@Override
	public List<Hospital> getHospitalByFeedback(int rating) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByFeedbackRatings(rating);
	}

	@Override
	public List<Hospital> getHospitalByLocation(String location, String city) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByAddressLocationAndAddressCity(location, city);
	}

	@Override
	public List<Hospital> getHospitalByPinCode(double pincode) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByAddressPincode(pincode);
	}

	@Override
	public List<Hospital> getHospitalByLocationAndFeedbackRatings(String location, String city, int rating) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByAddressLocationAndAddressCityAndFeedbackRatings(location, city, rating);
	}

	@Override
	public List<Hospital> gethospitalByspecialization(String specialization) {
		// TODO Auto-generated method stub
		return iHospitalRepository.findByDescription(specialization);
	}

	@Override
	public void addFeedback(int id, int ratings) {
		// TODO Auto-generated method stub
		Hospital hospital= iHospitalRepository.findById(id).orElse(null);
		Feedback f=new Feedback();
		f.setRatings(ratings);
		hospital.setFeedback(f);
		iHospitalRepository.save(hospital);
		
		
	}

}
