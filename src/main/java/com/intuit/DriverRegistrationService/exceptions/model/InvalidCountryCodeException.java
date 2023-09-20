package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

/**
 * Custom exception class representing an invalid country code error.
 * This exception is thrown when a provided country code is invalid or not onboarded to the system.
 */
public class InvalidCountryCodeException extends BadRequestException {

    /**
     * Constructs a new {@code InvalidCountryCodeException} with the requested country code.
     *
     */
    public InvalidCountryCodeException(final String message) {
        super(BadRequestExceptionCode.INVALID_COUNTRY_CODE , message);
    }
}
