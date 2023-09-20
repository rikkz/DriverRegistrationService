package com.intuit.DriverRegistrationService.model.request;

import lombok.*;

import java.time.LocalDate;
import com.intuit.DriverRegistrationService.model.request.common.Address;
import com.intuit.DriverRegistrationService.model.request.common.Gender;
import com.intuit.DriverRegistrationService.model.request.common.Name;


/**
 * Represents a request to register a driver.
 */
@Getter
@Builder
public class RegisterDriverRequest {
    /**
     * Represents the driver's name.
     */
    @NonNull
    private Name name;

    /**
     * Represents the driver's date of birth in yyyy-MM-dd format.
     */
    @NonNull
    private LocalDate dob;

    /**
     * Represents the driver's gender, which can be one of BOY, GIRL, or OTHER.
     */
    @NonNull
    private Gender gender;

    /**
     * Represents the driver's email address.
     */
    private String emailId;

    /**
     * Represents the country code for the driver's phone number.
     */
    @NonNull
    private String countryCode;

    /**
     * Represents the driver's phone number.
     */
    @NonNull
    private String phoneNumber;

    /**
     * Represents the driver's current address.
     */
    @NonNull
    private Address currentAddress;

    /**
     * Represents the driver's permanent address.
     */
    @NonNull
    private Address permanentAddress;
}

