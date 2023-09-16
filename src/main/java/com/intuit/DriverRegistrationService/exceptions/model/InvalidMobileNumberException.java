package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class InvalidMobileNumberException extends BadRequestException {
    public InvalidMobileNumberException(final String requestedMobileNumber) {
        super(BadRequestExceptionCode.INVALID_MOBILE_NUMBER ,
                String.format("Following Mobile Number : %s , doesn't match the length of a corresponding countryCode",
                    requestedMobileNumber));
    }
}
