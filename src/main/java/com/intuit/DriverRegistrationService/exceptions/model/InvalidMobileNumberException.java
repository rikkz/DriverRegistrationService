package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

/**
 * Custom exception class representing an invalid mobile number error.
 * This exception is thrown when a provided mobile number does not match the expected length
 * for a corresponding country code.
 */
public class InvalidMobileNumberException extends BadRequestException {

    /**
     * Constructs a new {@code InvalidMobileNumberException} with the requested mobile number.
     *
     * @param requestedMobileNumber The mobile number that triggered the exception.
     */
    public InvalidMobileNumberException(final String requestedMobileNumber) {
        super(BadRequestExceptionCode.INVALID_MOBILE_NUMBER ,
                String.format("Following Mobile Number : %s , doesn't match the length of a corresponding countryCode",
                    requestedMobileNumber));
    }
}
