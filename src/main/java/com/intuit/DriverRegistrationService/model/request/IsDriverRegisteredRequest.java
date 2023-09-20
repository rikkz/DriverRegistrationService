package com.intuit.DriverRegistrationService.model.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

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
    @NonNull
    private String countryCode;

    /**
     * The mobile number of the driver to be checked for registration status.
     * It represents the driver's unique identifier within the specified country.
     */
    @NonNull
    private String mobileNumber;
}
