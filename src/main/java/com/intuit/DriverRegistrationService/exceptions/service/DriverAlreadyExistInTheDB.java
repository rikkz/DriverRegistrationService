package com.intuit.DriverRegistrationService.exceptions.service;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;
import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;

/**
 * Runtime Exception if the Driver already exist in the system.
 */
public class DriverAlreadyExistInTheDB extends BadRequestException {

    /**
     * Constructs a new {@code BadRequestException} with the specified error code and message.
     * @param message A description of the error or additional context information.
     */
    public DriverAlreadyExistInTheDB(String message) {
        super(BadRequestExceptionCode.DRIVER_ALREADY_EXIST, message);
    }
}
