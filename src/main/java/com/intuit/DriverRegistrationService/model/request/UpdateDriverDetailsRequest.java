package com.intuit.DriverRegistrationService.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;

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
     * Represents the driver's email address.
     */
    @NonNull
    @Email(message = "Invalid email address")
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

    /**
     * Represents the driver's name, including first name, middle name, and last name.
     */
    @Getter
    @Builder
    public static class Name {
        /**
         * Represents the first name of the driver.
         */
        @NotBlank
        @NonNull
        @Size(min = 1, max = 20, message = "First name length must be between 1 and 20 characters")
        private String firstName;

        /**
         * Represents the middle name of the driver.
         */
        private String middleName;

        /**
         * Represents the last name of the driver.
         */
        @NotBlank
        @NonNull
        @Size(min = 1, max = 20, message = "Last name length must be between 1 and 20 characters")
        private String lastName;
    }

    /**
     * Represents an address, including address lines, state, country, and zip code.
     */
    @Getter
    @Builder
    public static class Address {
        /**
         * Represents the first line of the address.
         */
        @NonNull
        @Size(min = 5, max = 100, message = "AddressLine 1 length must be between 5 and 100 characters")
        private String addressLine1;

        /**
         * Represents the second line of the address.
         */
        @Size(max = 100, message = "AddressLine 2 length must be max 100 characters")
        private String addressLine2;

        /**
         * Represents the third line of the address.
         */
        @Size(max = 100, message = "AddressLine 3 length must be max 100 characters")
        private String addressLine3;

        /**
         * Represents the state of the address.
         */
        @NonNull
        @Size(min = 5, max = 20, message = "State length must be between 5 and 20 characters")
        private String state;

        /**
         * Represents the country of the address.
         */
        @NonNull
        @Size(min = 5, max = 30, message = "Country length must be between 5 and 30 characters")
        private String country;

        /**
         * Represents the zip code of the address.
         */
        @NonNull
        @Size(min = 5, max = 10, message = "ZipCode length must be between 5 and 10 characters")
        private String zipCode;
    }

    /**
     * Represents the gender of the driver.
     */
    public enum Gender {
        MALE, FEMALE, NOT_SPECIFIED
    }
}
