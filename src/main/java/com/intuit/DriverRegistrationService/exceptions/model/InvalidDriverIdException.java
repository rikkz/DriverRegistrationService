package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class InvalidDriverIdException extends BadRequestException {

    public InvalidDriverIdException(final String message) {
        super(BadRequestExceptionCode.INVALID_DRIVER_ID , message);
    }
}
