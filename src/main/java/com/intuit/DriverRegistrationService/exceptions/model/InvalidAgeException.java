package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

/**
 * Run time Exception for the Invalid Age
 */
public class InvalidAgeException extends BadRequestException {

    /**
     * Throws the exception with the defined Invalid age code.
     * @param message
     */
    public InvalidAgeException(final String message) {
        super(BadRequestExceptionCode.INVALID_AGE , message);
    }
}
