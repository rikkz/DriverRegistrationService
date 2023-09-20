package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class InvalidEmailAddressException extends BadRequestException {

    public InvalidEmailAddressException(final String message) {
        super(BadRequestExceptionCode.INVALID_EMAIL_ID , message);
    }
}
