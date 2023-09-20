package com.intuit.DriverRegistrationService.model.request;

import com.intuit.DriverRegistrationService.model.request.common.Address;
import com.intuit.DriverRegistrationService.model.request.common.Gender;
import com.intuit.DriverRegistrationService.model.request.common.Name;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

/**
 * Following Class represents the request object to Update the Existing Driver's Details.
 */
@Getter
@Builder
public class UpdateDriverDetailsRequest {
    /**
     * Represents the driver's name.
     */
    @NonNull
    private String driverId;

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
