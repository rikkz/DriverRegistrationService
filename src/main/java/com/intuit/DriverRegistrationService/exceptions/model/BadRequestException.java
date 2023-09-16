package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class BadRequestException extends RuntimeException {

    private final BadRequestExceptionCode badRequestExceptionCode;
    public BadRequestException(final BadRequestExceptionCode code , final String message) {
        super(message);
        badRequestExceptionCode = code;
    }
}
