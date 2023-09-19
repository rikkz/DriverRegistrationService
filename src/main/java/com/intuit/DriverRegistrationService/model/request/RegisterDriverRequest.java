package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

import lombok.Builder;
import lombok.Getter;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a request to register a driver.
 */
@Getter
@Builder
public class RegisterDriverRequest {
    /**
     * Represents the driver's name.
     */
    private Name name;

    /**
     * Represents the driver's date of birth in yyyy-MM-dd format.
     */
    private Date dob;

    /**
     * Represents the driver's gender, which can be one of BOY, GIRL, or OTHER.
     */
    private Gender gender;

    /**
     * Represents the driver's email address.
     */
    private String emailId;

    /**
     * Represents the country code for the driver's phone number.
     */
    private String countryCode;

    /**
     * Represents the driver's phone number.
     */
    private String phoneNumber;

    /**
     * Represents the driver's current address.
     */
    private Address currentAddress;

    /**
     * Represents the driver's permanent address.
     */
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
        private String firstName;

        /**
         * Represents the middle name of the driver.
         */
        private String middleName;

        /**
         * Represents the last name of the driver.
         */
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
        private String addressLine1;

        /**
         * Represents the second line of the address.
         */
        private String addressLine2;

        /**
         * Represents the third line of the address.
         */
        private String addressLine3;

        /**
         * Represents the state of the address.
         */
        private String state;

        /**
         * Represents the country of the address.
         */
        private String country;

        /**
         * Represents the zip code of the address.
         */
        private String zipCode;
    }

    /**
     * Represents the gender of the driver.
     */
    public enum Gender {
        MALE, FEMALE, NOT_SPECIFIED
    }
}

