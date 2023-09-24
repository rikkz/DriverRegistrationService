package com.intuit.DriverRegistrationService.repository;

import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The {@code DriverRepository} interface provides methods for interacting with the driver data
 * stored in the MongoDB database.
 */
public interface DriverRepository extends MongoRepository<DriverDataModel, String> {

    /**
     * Find drivers by their country code and mobile number.
     *
     * @param countryCode   The country code associated with the mobile number.
     * @param mobileNumber  The mobile phone number of the driver.
     * @return A list of {@link DriverDataModel} objects matching the given country code and mobile number.
     */
    List<DriverDataModel> findByMobileNumber(String mobileNumber);
}
