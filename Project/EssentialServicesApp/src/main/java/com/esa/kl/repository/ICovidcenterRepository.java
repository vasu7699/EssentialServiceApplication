package com.esa.kl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esa.kl.model.Covidcenter;

@Repository
public interface ICovidcenterRepository extends MongoRepository<Covidcenter, Integer>{
	List<Covidcenter> findByAddressLocationAndAddressCityOrAddressPincode(String location,String city,double pincode);
	List<Covidcenter> findByDescription(String description);
}
