package com.intuit.DriverRegistrationService.exceptions.handler;

import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler class responsible for handling custom exceptions in the application and translating
 * them into appropriate HTTP responses.
 * This class is annotated with {@code @ControllerAdvice} to provide centralized exception handling for controllers.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Exception handler method for handling {@code BadRequestException}.
     * Translates the exception into a 400 Bad Request HTTP response with the exception message in the response body.
     *
     * @param ex The {@code BadRequestException} to be handled.
     * @return A {@code ResponseEntity} with a 400 Bad Request status code and the exception message in the response body.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
