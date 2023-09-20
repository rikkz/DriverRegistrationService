package com.intuit.DriverRegistrationService.repository;

import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<DriverDataModel, String> {
}
