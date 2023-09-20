package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class InvalidAgeException extends BadRequestException {

    public InvalidAgeException(final String message) {
        super(BadRequestExceptionCode.INVALID_EMAIL_ID , message);
    }
}
