package com.intuit.DriverRegistrationService.exceptions.service;

import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;

import static com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode.DRIVER_DOES_NOT_EXIST;

/**
 * Runtime Exception if the Driver doesn't exist in the system.
 */
public class DriverDoesNotExistInTheDB extends BadRequestException {
    /**
     * Constructs a new {@code BadRequestException} with the specified error code and message.
     * @param message A description of the error or additional context information.
     */
    public DriverDoesNotExistInTheDB(String message) {
        super(DRIVER_DOES_NOT_EXIST, message);
    }
}
