package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

/**
 * Custom exception class representing an invalid country code error.
 * This exception is thrown when a provided country code is invalid or not onboarded to the system.
 */
public class InvalidCountryCodeException extends BadRequestException{

    /**
     * Constructs a new {@code InvalidCountryCodeException} with the requested country code.
     *
     * @param requestedCountryCode The country code that triggered the exception.
     */
    public InvalidCountryCodeException(final String requestedCountryCode) {
        super(BadRequestExceptionCode.INVALID_COUNTRY_CODE ,
                String.format("Following Country Code : %s , Doesn't exist or onboarded to our system",
                        requestedCountryCode));
    }
}
