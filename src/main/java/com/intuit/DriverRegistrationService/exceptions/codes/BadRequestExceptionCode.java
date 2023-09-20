package com.intuit.DriverRegistrationService.exceptions.codes;

/**
 * Enumeration representing specific error codes for bad request scenarios in the application.
 * Each code corresponds to a distinct type of bad request error.
 */
public enum BadRequestExceptionCode {

    /**
     * Error code indicating that the provided country code is invalid.
     * This error typically occurs when the country code format is incorrect or unsupported.
     */
    INVALID_COUNTRY_CODE,

    /**
     * Error code indicating that the provided mobile number is invalid.
     * This error typically occurs when the mobile number format is incorrect or does not meet the required criteria.
     */
    INVALID_MOBILE_NUMBER,

    /**
     * Error code indicating that the provided driverId is invalid.
     */
    INVALID_DRIVER_ID,

    /**
     * Error code indicating that the provided email ID is invalid.
     */
    INVALID_EMAIL_ID,

    /**
     * Error code indicating that the provided age is invalid.
     */
    INVALID_AGE,

    /**
     * Error code indicating that driver doesn't exist.
     */
    DRIVER_DOES_NOT_EXIST,

    /**
     * Error code indicating that driver already exist.
     */
    DRIVER_ALREADY_EXIST
}
