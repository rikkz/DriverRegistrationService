package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

/**
 * Custom exception class representing a bad request scenario in the application.
 * This exception is typically thrown when a client sends a request that cannot
 * be processed due to invalid input or other client-related errors.
 */
public class BadRequestException extends RuntimeException {

    /**
     * An enumeration representing specific error codes associated with the bad request.
     */
    private final BadRequestExceptionCode badRequestExceptionCode;

    /**
     * Constructs a new {@code BadRequestException} with the specified error code and message.
     *
     * @param code    The specific error code associated with the bad request.
     * @param message A description of the error or additional context information.
     */
    public BadRequestException(final BadRequestExceptionCode code , final String message) {
        super(message);
        badRequestExceptionCode = code;
    }
}
