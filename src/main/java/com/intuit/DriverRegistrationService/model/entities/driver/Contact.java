package com.intuit.DriverRegistrationService.model.entities.driver;

import lombok.Builder;

/**
 * The `ContactInformation` class represents an individual's contact information,
 * including email, country code, and mobile number.
 */
@Builder
public class Contact {

    /**
     * The email address of the individual.
     */
    private final String emailId;

    /**
     * The country code associated with the individual's phone number.
     */
    private final String countryCode;

    /**
     * The mobile phone number of the individual.
     */
    private final String mobileNumber;
}
