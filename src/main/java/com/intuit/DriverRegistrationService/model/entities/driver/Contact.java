package com.intuit.DriverRegistrationService.model.entities.driver;

import lombok.Builder;
import lombok.Getter;

/**
 * The `ContactInformation` class represents an individual's contact information,
 * including email, country code, and mobile number.
 */
@Builder
@Getter
public class Contact {

    /**
     * The email address of the individual.
     */
    private final String emailId;

    /**
     * The mobile phone number of the individual.
     */
    private final String mobileNumber;
}
