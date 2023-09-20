package com.intuit.DriverRegistrationService.repository;

import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DriverRepository extends MongoRepository<DriverDataModel, String> {

    List<DriverDataModel> findByCountryCodeAndMobileNumber(String countryCode, String mobileNumber);
}
