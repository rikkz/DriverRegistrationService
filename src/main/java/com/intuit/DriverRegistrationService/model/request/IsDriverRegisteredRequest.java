package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Data transfer object (DTO) class representing a request to check if a driver is registered.
 * This class is designed for use in API endpoints where clients can provide a country code and mobile number
 * for driver registration verification.
 */
@Builder
@Getter
public class IsDriverRegisteredRequest {

    /**
     * The country code associated with the driver's mobile number.
     * It specifies the country in which the driver's mobile number is registered.
     */
    private String countryCode;

    /**
     * The mobile number of the driver to be checked for registration status.
     * It represents the driver's unique identifier within the specified country.
     */
    private String mobileNumber;
}
