package com.esa.kl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.esa.kl.model.Hospital;

@Repository
public interface IHospitalRepository extends MongoRepository<Hospital, Integer> {
	
	
	List<Hospital> findByName(String name);
	List<Hospital> findByFeedbackRatings(int rating);
	List<Hospital> findByAddressLocationAndAddressCity(String location,String city);
    List<Hospital> findByAddressPincode(double pincode );
    List<Hospital> findByAddressLocationAndAddressCityAndFeedbackRatings(String location,String city,int ratings);
	List<Hospital> findByDescription(String description);
}
