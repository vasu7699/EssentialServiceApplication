package com.esa.kl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esa.kl.model.Pharmacy;

@Repository
public interface IPharmacyRepository extends MongoRepository<Pharmacy, Integer> {
	
	List<Pharmacy> findByAddressLocationAndAddressCityOrAddressPincode(String location,String city,double pincode);
	List<Pharmacy> findByFeedbackRatings(int rating);
}
